package com.example.projecttaskintern.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "style_id", nullable = false)
    private Style style;

    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "price", nullable = false, precision = 12, scale = 0)
    private BigDecimal price;
    @Column(name = "price_discount", precision = 12, scale = 0)
    private BigDecimal priceDiscount;
    @Column(name = "image", nullable = false)
    private String image;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private List<Rating> ratings = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    private Set<GalleryImage> gallery_images = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_color",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "color_id", referencedColumnName = "colorId")}
    )
    private Set<Color> colors = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_size",
            joinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "productId")},
            inverseJoinColumns = {@JoinColumn(name = "size_id", referencedColumnName = "sizeId")}
    )
    private Set<Size> sizes = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
