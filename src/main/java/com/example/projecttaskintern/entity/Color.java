package com.example.projecttaskintern.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long colorId;
    @Column(name = "color_code",nullable = false, length = 30)
    private String colorCode;
    @ManyToMany(mappedBy = "colors")
    @JsonIgnore
    private Set<Product> products = new HashSet<Product>(0);
}
