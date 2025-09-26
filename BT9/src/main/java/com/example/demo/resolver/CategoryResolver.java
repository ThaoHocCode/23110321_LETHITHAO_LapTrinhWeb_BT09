package com.example.demo.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;

@Controller
public class CategoryResolver {
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @QueryMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    @QueryMapping
    public Category getCategoryById(@Argument Long id) {
        return categoryRepository.findById(id).orElse(null);
    }
    
    @MutationMapping
    public Category createCategory(@Argument CategoryInput input) {
        Category category = new Category();
        category.setName(input.getName());
        category.setImages(input.getImages());
        return categoryRepository.save(category);
    }
    
    @MutationMapping
    public Category updateCategory(@Argument CategoryUpdateInput input) {
        Optional<Category> optionalCategory = categoryRepository.findById(input.getId());
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            if (input.getName() != null) {
                category.setName(input.getName());
            }
            if (input.getImages() != null) {
                category.setImages(input.getImages());
            }
            return categoryRepository.save(category);
        }
        return null;
    }
    
    @MutationMapping
    public Boolean deleteCategory(@Argument Long id) {
        try {
            categoryRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Inner classes for input types
    public static class CategoryInput {
        private String name;
        private String images;
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getImages() { return images; }
        public void setImages(String images) { this.images = images; }
    }
    
    public static class CategoryUpdateInput {
        private Long id;
        private String name;
        private String images;
        
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getImages() { return images; }
        public void setImages(String images) { this.images = images; }
    }
}
