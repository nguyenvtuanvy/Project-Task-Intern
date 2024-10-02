package com.example.projecttaskintern.repository;

import com.example.projecttaskintern.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
