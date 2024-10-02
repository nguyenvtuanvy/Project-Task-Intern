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
@Table(name = "Size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sizeId;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @ManyToMany(mappedBy = "sizes")
    @JsonIgnore
    private Set<Product> products = new HashSet<>();
}
