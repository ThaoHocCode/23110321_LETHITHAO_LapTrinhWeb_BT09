package com.example.demo.resolver;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.model.Category;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductResolver {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @QueryMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @QueryMapping
    public Product getProductById(@Argument Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    @QueryMapping
    public List<Product> getProductsByPriceAsc() {
        return productRepository.findAllByOrderByPriceAsc();
    }
    
    @QueryMapping
    public List<Product> getProductsByCategory(@Argument Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }
    
    @QueryMapping
    public List<Product> getProductsByUser(@Argument Long userId) {
        return productRepository.findByUserId(userId);
    }
    
    @MutationMapping
    public Product createProduct(@Argument ProductInput input) {
        Product product = new Product();
        product.setTitle(input.getTitle());
        product.setQuantity(input.getQuantity());
        product.setDescription(input.getDescription());
        product.setPrice(new BigDecimal(input.getPrice().toString()));
        product.setUserId(input.getUserId());
        product.setCategoryId(input.getCategoryId());
        return productRepository.save(product);
    }
    
    @MutationMapping
    public Product updateProduct(@Argument ProductUpdateInput input) {
        Optional<Product> optionalProduct = productRepository.findById(input.getId());
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            if (input.getTitle() != null) {
                product.setTitle(input.getTitle());
            }
            if (input.getQuantity() != null) {
                product.setQuantity(input.getQuantity());
            }
            if (input.getDescription() != null) {
                product.setDescription(input.getDescription());
            }
            if (input.getPrice() != null) {
                product.setPrice(new BigDecimal(input.getPrice().toString()));
            }
            if (input.getUserId() != null) {
                product.setUserId(input.getUserId());
            }
            if (input.getCategoryId() != null) {
                product.setCategoryId(input.getCategoryId());
            }
            return productRepository.save(product);
        }
        return null;
    }
    
    @MutationMapping
    public Boolean deleteProduct(@Argument Long id) {
        try {
            productRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Schema mapping for resolving nested objects
    @SchemaMapping
    public User user(Product product) {
        return userRepository.findById(product.getUserId()).orElse(null);
    }
    
    @SchemaMapping
    public Category category(Product product) {
        if (product.getCategoryId() != null) {
            return categoryRepository.findById(product.getCategoryId()).orElse(null);
        }
        return null;
    }
    
    // Inner classes for input types
    public static class ProductInput {
        private String title;
        private Integer quantity;
        private String description;
        private Double price;
        private Long userId;
        private Long categoryId;
        
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public Long getCategoryId() { return categoryId; }
        public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    }
    
    public static class ProductUpdateInput {
        private Long id;
        private String title;
        private Integer quantity;
        private String description;
        private Double price;
        private Long userId;
        private Long categoryId;
        
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        public Double getPrice() { return price; }
        public void setPrice(Double price) { this.price = price; }
        public Long getUserId() { return userId; }
        public void setUserId(Long userId) { this.userId = userId; }
        public Long getCategoryId() { return categoryId; }
        public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    }
}
