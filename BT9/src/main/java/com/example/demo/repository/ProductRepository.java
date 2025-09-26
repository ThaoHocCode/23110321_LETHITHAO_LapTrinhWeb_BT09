package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Find all products ordered by price (low to high)
    List<Product> findAllByOrderByPriceAsc();
    
    // Find all products by category ID
    List<Product> findByCategoryId(Long categoryId);
    
    // Find all products by user ID
    List<Product> findByUserId(Long userId);
}
