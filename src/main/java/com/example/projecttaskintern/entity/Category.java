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
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
}
