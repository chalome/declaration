package com.declaration.repositories;

import com.declaration.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // You can add custom queries if needed, for example:
    Category findByNom(String nom);
}
