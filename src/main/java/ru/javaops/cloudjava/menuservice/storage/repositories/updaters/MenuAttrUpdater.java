package ru.javaops.cloudjava.menuservice.storage.repositories.updaters;

import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.SingularAttribute;
import lombok.AllArgsConstructor;
import ru.javaops.cloudjava.menuservice.dto.UpdateMenuRequest;
import ru.javaops.cloudjava.menuservice.storage.model.MenuItem;

import javax.sound.midi.MidiFileFormat;
import java.util.function.Function;

@AllArgsConstructor
public class MenuAttrUpdater<V> {
    SingularAttribute<MenuItem, V> attr;
    Function<UpdateMenuRequest, V> dtoValueExtractor;

    public void updateAttr(CriteriaUpdate<MenuItem> criteria, UpdateMenuRequest dto) {
        if (dto == null) {
            return;
        }

        V apply = dtoValueExtractor.apply(dto);
        if (apply == null) {
            return;
        }
        criteria.set(attr, apply);
    }
}
