package ru.javaops.cloudjava.menuservice.storage.model;

import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "menu_items")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "price", precision = 6, scale = 2)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(name = "time_to_cook")
    private Long timeToCook;
    private Float weight;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "ingredient_collection", columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private IngredientCollection ingredientCollection;
    @Column(name = "created_at")
    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;

    @Override
    public int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
                : getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        Class<?> objEffectiveClass = getAClass(obj);
        Class<?> thisEffectiveClass = getAClass(this);
        if (thisEffectiveClass != objEffectiveClass) return false;

        MenuItem menuItem = (MenuItem) obj;
        return getId() != null && Objects.equals(menuItem.getId(), this.getId());
    }

    private static Class<?> getAClass(Object obj) {
        return obj instanceof HibernateProxy ? ((HibernateProxy) obj).getHibernateLazyInitializer().getPersistentClass() : obj.getClass();
    }
}

