package com.declaration.repositories;

import com.declaration.models.TypeDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeDeclarationRepository extends JpaRepository<TypeDeclaration, Integer> {
}
