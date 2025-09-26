package com.example.demo.resolver;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserResolver {
    
    @Autowired
    private UserRepository userRepository;
    
    @QueryMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    @QueryMapping
    public User getUserById(@Argument Long id) {
        return userRepository.findById(id).orElse(null);
    }
    
    @QueryMapping
    public User getUserByEmail(@Argument String email) {
        return userRepository.findByEmail(email);
    }
    
    @MutationMapping
    public User createUser(@Argument UserInput input) {
        User user = new User();
        user.setFullname(input.getFullname());
        user.setEmail(input.getEmail());
        user.setPassword(input.getPassword());
        user.setPhone(input.getPhone());
        return userRepository.save(user);
    }
    
    @MutationMapping
    public User updateUser(@Argument UserUpdateInput input) {
        Optional<User> optionalUser = userRepository.findById(input.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (input.getFullname() != null) {
                user.setFullname(input.getFullname());
            }
            if (input.getEmail() != null) {
                user.setEmail(input.getEmail());
            }
            if (input.getPassword() != null) {
                user.setPassword(input.getPassword());
            }
            if (input.getPhone() != null) {
                user.setPhone(input.getPhone());
            }
            return userRepository.save(user);
        }
        return null;
    }
    
    @MutationMapping
    public Boolean deleteUser(@Argument Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Inner classes for input types
    public static class UserInput {
        private String fullname;
        private String email;
        private String password;
        private String phone;
        
        public String getFullname() { return fullname; }
        public void setFullname(String fullname) { this.fullname = fullname; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
    }
    
    public static class UserUpdateInput {
        private Long id;
        private String fullname;
        private String email;
        private String password;
        private String phone;
        
        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }
        public String getFullname() { return fullname; }
        public void setFullname(String fullname) { this.fullname = fullname; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getPhone() { return phone; }
        public void setPhone(String phone) { this.phone = phone; }
    }
}
