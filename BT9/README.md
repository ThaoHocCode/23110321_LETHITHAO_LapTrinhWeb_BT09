# BT9 - GraphQL API Management System

## 📋 Tổng quan

Dự án **BT9** là một hệ thống quản lý sản phẩm, danh mục và người dùng được xây dựng bằng **Spring Boot 3** và **GraphQL**. Hệ thống cung cấp API GraphQL mạnh mẽ với giao diện web thân thiện và các tính năng CRUD đầy đủ.

## 🚀 Tính năng chính

### 📊 Quản lý dữ liệu
- **Sản phẩm**: CRUD operations với tìm kiếm theo giá và danh mục
- **Danh mục**: Quản lý các danh mục sản phẩm với hình ảnh
- **Người dùng**: Quản lý thông tin người dùng với mối quan hệ nhiều-nhiều

### 🔍 API GraphQL
- **Queries**: Truy vấn dữ liệu linh hoạt
- **Mutations**: Thao tác tạo, sửa, xóa dữ liệu
- **Real-time**: Cập nhật dữ liệu theo thời gian thực

### 🎨 Giao diện người dùng
- **Responsive Design**: Tương thích với mọi thiết bị
- **Modern UI**: Sử dụng Bootstrap 5 và Font Awesome
- **AJAX Integration**: Tương tác mượt mà với GraphQL API

## 🛠️ Công nghệ sử dụng

### Backend
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Spring GraphQL**
- **H2 Database** (In-memory)
- **Maven** (Build tool)

### Frontend
- **Thymeleaf** (Template engine)
- **Bootstrap 5** (CSS Framework)
- **Font Awesome** (Icons)
- **JavaScript ES6+** (AJAX, Fetch API)

### Database
- **H2 Database** (Development)
- **JPA/Hibernate** (ORM)

## 📁 Cấu trúc dự án

```
BT9/
├── src/
│   ├── main/
│   │   ├── java/com/example/demo/
│   │   │   ├── model/           # Entity classes
│   │   │   │   ├── Category.java
│   │   │   │   ├── User.java
│   │   │   │   └── Product.java
│   │   │   ├── repository/      # Data repositories
│   │   │   │   ├── CategoryRepository.java
│   │   │   │   ├── UserRepository.java
│   │   │   │   └── ProductRepository.java
│   │   │   ├── resolver/        # GraphQL resolvers
│   │   │   │   ├── CategoryResolver.java
│   │   │   │   ├── UserResolver.java
│   │   │   │   └── ProductResolver.java
│   │   │   ├── controller/      # Web controllers
│   │   │   │   └── ViewController.java
│   │   │   ├── service/         # Business logic
│   │   │   │   └── DataInitializer.java
│   │   │   └── Bt9Application.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── graphql/
│   │       │   └── schema.graphqls
│   │       └── templates/
│   │           ├── index.html
│   │           ├── products.html
│   │           ├── categories.html
│   │           └── users.html
│   └── test/
├── pom.xml
└── README.md
```

## 🗄️ Mô hình dữ liệu

### Entity Relationships
```
User (1) ←→ (N) Product
Category (1) ←→ (N) Product
User (N) ←→ (N) Category (Many-to-Many)
```

### Database Schema
- **users**: id, fullname, email, password, phone
- **categories**: id, name, images
- **products**: id, title, quantity, description, price, user_id, category_id

## 🚀 Cài đặt và chạy

### Yêu cầu hệ thống
- **Java 17+**
- **Maven 3.6+**
- **IDE** (IntelliJ IDEA, Eclipse, VS Code)

### Các bước cài đặt

1. **Clone repository**
```bash
git clone <repository-url>
cd BT9
```

2. **Cài đặt dependencies**
```bash
mvn clean install
```

3. **Chạy ứng dụng**
```bash
mvn spring-boot:run
```

4. **Truy cập ứng dụng**
- **Trang chủ**: http://localhost:8081
- **GraphiQL**: http://localhost:8081/graphiql
- **H2 Console**: http://localhost:8081/h2-console

## 📚 API Documentation

### GraphQL Endpoints
- **GraphQL API**: `POST /graphql`
- **GraphiQL Playground**: `GET /graphiql`

### Queries

#### Lấy tất cả sản phẩm
```graphql
query {
  getAllProducts {
    id
    title
    quantity
    price
    description
    userId
    categoryId
  }
}
```

#### Sắp xếp sản phẩm theo giá (thấp → cao)
```graphql
query {
  getProductsByPriceAsc {
    id
    title
    price
    quantity
  }
}
```

#### Lấy sản phẩm theo danh mục
```graphql
query GetProductsByCategory($categoryId: ID!) {
  getProductsByCategory(categoryId: $categoryId) {
    id
    title
    price
    categoryId
  }
}
```

#### Lấy tất cả danh mục
```graphql
query {
  getAllCategories {
    id
    name
    images
  }
}
```

#### Lấy tất cả người dùng
```graphql
query {
  getAllUsers {
    id
    fullname
    email
    phone
  }
}
```

### Mutations

#### Tạo sản phẩm mới
```graphql
mutation CreateProduct($input: ProductInput!) {
  createProduct(input: $input) {
    id
    title
    quantity
    price
    description
    userId
    categoryId
  }
}
```

#### Tạo danh mục mới
```graphql
mutation CreateCategory($input: CategoryInput!) {
  createCategory(input: $input) {
    id
    name
    images
  }
}
```

#### Tạo người dùng mới
```graphql
mutation CreateUser($input: UserInput!) {
  createUser(input: $input) {
    id
    fullname
    email
    phone
  }
}
```

## 🎯 Dữ liệu mẫu

Hệ thống tự động tạo dữ liệu mẫu khi khởi động lần đầu:

### Categories (4 danh mục)
- **Điện tử** - Thiết bị điện tử
- **Thời trang** - Quần áo, phụ kiện
- **Sách** - Sách và tài liệu
- **Gia dụng** - Đồ dùng gia đình

### Users (3 người dùng)
- **Nguyễn Văn An** - an.nguyen@email.com
- **Trần Thị Bình** - binh.tran@email.com
- **Lê Văn Cường** - cuong.le@email.com

### Products (8 sản phẩm)
- iPhone 15 Pro (25,000,000 VND)
- Samsung Galaxy S24 (22,000,000 VND)
- Áo thun nam cao cấp (350,000 VND)
- Váy đầm nữ (850,000 VND)
- Clean Code (450,000 VND)
- Design Patterns (380,000 VND)
- Máy lọc nước RO (3,500,000 VND)
- Nồi cơm điện tử (1,200,000 VND)

## 🔧 Cấu hình


## 🧪 Testing

### Test GraphQL API với GraphiQL
1. Truy cập http://localhost:8081/graphiql
2. Sử dụng các query/mutation mẫu ở trên
3. Kiểm tra kết quả trả về

### Test Web Interface
1. Truy cập http://localhost:8081/products
2. Thử các chức năng:
   - Xem danh sách sản phẩm
   - Thêm sản phẩm mới
   - Sắp xếp theo giá
   - Lọc theo danh mục

## 🚀 Tính năng nâng cao

### Đã implement
- ✅ CRUD operations cho tất cả entities
- ✅ GraphQL API với queries và mutations
- ✅ Web interface với AJAX
- ✅ Responsive design
- ✅ Data validation
- ✅ Error handling

### Có thể phát triển thêm
- 🔄 Real-time updates với WebSocket
- 🔐 Authentication & Authorization
- 📊 Analytics và reporting
- 📱 Mobile app integration
- 🗄️ Database migration scripts
- 🧪 Unit tests và integration tests

## 🤝 Đóng góp

1. Fork repository
2. Tạo feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to branch (`git push origin feature/AmazingFeature`)
5. Tạo Pull Request



## 👨‍💻 Tác giả

**Lê Thị Thảo** - 23110321


