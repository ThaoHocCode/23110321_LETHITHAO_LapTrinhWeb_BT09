package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;

@Service
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        // Tạo dữ liệu mẫu nếu chưa có
        if (categoryRepository.count() == 0) {
            createSampleData();
        }
    }

    private void createSampleData() {
        // Tạo Categories
        Category electronics = new Category();
        electronics.setName("Điện tử");
        electronics.setImages("https://images.unsplash.com/photo-1498049794561-7780e7231661?w=400");
        electronics = categoryRepository.save(electronics);

        Category clothing = new Category();
        clothing.setName("Thời trang");
        clothing.setImages("https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=400");
        clothing = categoryRepository.save(clothing);

        Category books = new Category();
        books.setName("Sách");
        books.setImages("https://images.unsplash.com/photo-1481627834876-b7833e8f5570?w=400");
        books = categoryRepository.save(books);

        Category home = new Category();
        home.setName("Gia dụng");
        home.setImages("https://images.unsplash.com/photo-1586023492125-27b2c045efd7?w=400");
        home = categoryRepository.save(home);

        // Tạo Users
        User user1 = new User();
        user1.setFullname("Nguyễn Văn An");
        user1.setEmail("an.nguyen@email.com");
        user1.setPassword("password123");
        user1.setPhone("0123456789");
        user1 = userRepository.save(user1);

        User user2 = new User();
        user2.setFullname("Trần Thị Bình");
        user2.setEmail("binh.tran@email.com");
        user2.setPassword("password123");
        user2.setPhone("0987654321");
        user2 = userRepository.save(user2);

        User user3 = new User();
        user3.setFullname("Lê Văn Cường");
        user3.setEmail("cuong.le@email.com");
        user3.setPassword("password123");
        user3.setPhone("0369258147");
        user3 = userRepository.save(user3);

        // Tạo Products
        Product product1 = new Product();
        product1.setTitle("iPhone 15 Pro");
        product1.setQuantity(10);
        product1.setPrice(new BigDecimal("25000000"));
        product1.setDescription("iPhone 15 Pro với chip A17 Pro mạnh mẽ, camera 48MP và thiết kế titan cao cấp");
        product1.setUserId(user1.getId());
        product1.setCategoryId(electronics.getId());
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setTitle("Samsung Galaxy S24");
        product2.setQuantity(15);
        product2.setPrice(new BigDecimal("22000000"));
        product2.setDescription("Samsung Galaxy S24 với AI tích hợp, camera 200MP và pin 4000mAh");
        product2.setUserId(user1.getId());
        product2.setCategoryId(electronics.getId());
        productRepository.save(product2);

        Product product3 = new Product();
        product3.setTitle("Áo thun nam cao cấp");
        product3.setQuantity(50);
        product3.setPrice(new BigDecimal("350000"));
        product3.setDescription("Áo thun nam chất liệu cotton 100%, thiết kế đơn giản và thoải mái");
        product3.setUserId(user2.getId());
        product3.setCategoryId(clothing.getId());
        productRepository.save(product3);

        Product product4 = new Product();
        product4.setTitle("Váy đầm nữ");
        product4.setQuantity(30);
        product4.setPrice(new BigDecimal("850000"));
        product4.setDescription("Váy đầm nữ thiết kế hiện đại, phù hợp cho công sở và dự tiệc");
        product4.setUserId(user2.getId());
        product4.setCategoryId(clothing.getId());
        productRepository.save(product4);

        Product product5 = new Product();
        product5.setTitle("Clean Code - Robert Martin");
        product5.setQuantity(25);
        product5.setPrice(new BigDecimal("450000"));
        product5.setDescription("Cuốn sách kinh điển về lập trình sạch và best practices trong phát triển phần mềm");
        product5.setUserId(user3.getId());
        product5.setCategoryId(books.getId());
        productRepository.save(product5);

        Product product6 = new Product();
        product6.setTitle("Design Patterns");
        product6.setQuantity(20);
        product6.setPrice(new BigDecimal("380000"));
        product6.setDescription("Gang of Four - Các mẫu thiết kế phần mềm cơ bản cho lập trình viên");
        product6.setUserId(user3.getId());
        product6.setCategoryId(books.getId());
        productRepository.save(product6);

        Product product7 = new Product();
        product7.setTitle("Máy lọc nước RO");
        product7.setQuantity(8);
        product7.setPrice(new BigDecimal("3500000"));
        product7.setDescription("Máy lọc nước RO 9 cấp, công suất 10L/h, tiết kiệm điện");
        product7.setUserId(user1.getId());
        product7.setCategoryId(home.getId());
        productRepository.save(product7);

        Product product8 = new Product();
        product8.setTitle("Nồi cơm điện tử");
        product8.setQuantity(12);
        product8.setPrice(new BigDecimal("1200000"));
        product8.setDescription("Nồi cơm điện tử 1.8L, nấu cơm ngon và tiết kiệm điện");
        product8.setUserId(user2.getId());
        product8.setCategoryId(home.getId());
        productRepository.save(product8);

        System.out.println("✅ Đã tạo dữ liệu mẫu thành công!");
        System.out.println("📊 Thống kê:");
        System.out.println("- Categories: " + categoryRepository.count());
        System.out.println("- Users: " + userRepository.count());
        System.out.println("- Products: " + productRepository.count());
    }
}
