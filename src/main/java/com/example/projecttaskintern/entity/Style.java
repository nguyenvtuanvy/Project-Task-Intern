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
@Table(name = "Style")
public class Style {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long styleId;
    @Column(name = "name", nullable = false, unique = true, length = 50)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "style")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
}
