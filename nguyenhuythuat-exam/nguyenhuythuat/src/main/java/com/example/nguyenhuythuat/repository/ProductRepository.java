package com.example.nguyenhuythuat.repository;

import com.example.nguyenhuythuat.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
