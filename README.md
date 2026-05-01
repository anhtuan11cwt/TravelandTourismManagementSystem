# Hệ thống Quản lý Du lịch và Du ngoạn (Travel and Tourism Management System)

Ứng dụng Java Swing Desktop quản lý tour du lịch và đặt khách sạn cho khách hàng.

## Công nghệ sử dụng

| Thành phần | Công nghệ |
|---|---|
| Ngôn ngữ | Java |
| Giao diện | Java Swing (AWT) |
| Cơ sở dữ liệu | MariaDB |
| Build tool | Maven |
| JDBC Driver | mariadb-java-client 3.1.0 |

## Cấu trúc dự án

```
TravelandTourismManagementSystem/
├── src/main/java/org/example/
│   ├── App.java              # Entry point (gọi Splash)
│   ├── Conn.java             # Kết nối MariaDB
│   ├─�� Splash.java           # Màn hình splash/loading
│   ├── Login.java           # Đăng nhập / Đăng ký / Quên mật khẩu
│   ├── Signup.java         # Tạo tài khoản mới
│   ├── ForgotPassword.java  # Khôi phục mật khẩu
│   ├── Dashboard.java     # Bảng điều khiển chính
│   ├── AddCustomer.java    # Thêm thông tin cá nhân
│   ├── UpdateCustomer.java # Cập nhật thông tin
│   ├── ViewCustomer.java  # Xem thông tin khách hàng
│   ├── DeleteDetails.java  # Xóa thông tin
│   ├── CheckPackage.java  # Xem các gói du lịch (Vàng/Bạc/Đồng)
│   ├── BookPackage.java   # Đặt gói du lịch
│   ├── ViewBookedPackage.java # Xem gói đã đặt
│   ├── CheckHotels.java  # Slideshow khách sạn
│   ├── BookHotel.java    # Đặt phòng khách sạn
│   ├── ViewBookedHotel.java # Xem phòng đã đặt
│   ├── Destinations.java # Slideshow điểm đến
│   ├── Payment.java     # Thanh toán
│   ├── About.java      # Thông tin ứng dụng
│   ├── Loading.java   # Loading bar sau đăng nhập
│   └── Paytm.java    # Calculator
├── database.ql            # Script tạo database + dữ liệu mẫu
├── pom.xml
└── README.md
```

## Tính năng chính

- **Quản lý tài khoản**: Đăng nhập, đăng ký, quên mật khẩu
- **Quản lý khách hàng**: Thêm, xem, cập nhật, xóa thông tin cá nhân
- **Gói du lịch**: 3 gói (Vàng 12000, Bạc 25000, Đồng 15000) với thời hạn khác nhau
- **Đặt khách sạn**: Chọn khách sạn, số người, số ngày, loại phòng, bao gồm ăn
- **Xem đặt phòng**: Liệt kê các gói/khách sạn đã đặt
- **Slideshow**: Ảnh khách sạn và điểm đến du lịch
- **Thanh toán & tiện ích**: Mở calculator, notepad

## Cài đặt

### 1. Cài đặt MariaDB

```sql
-- Tạo database và import dữ liệu
CREATE DATABASE IF NOT EXISTS travelmanagementsystem;
USE travelmanagementsystem;
-- Chạy toàn bộ file database.ql
```

### 2. Cấu hình kết nối

Kiểm tra `Conn.java:12`:
```java
c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/travelmanagementsystem", "root", "123456");
```
Sửa username/password MariaDB nếu cần.

### 3. Thêm icons (nếu chưa có)

Tạo thư mục `src/main/resources/icons/` và thêm các file ảnh:

| File | Mô tả |
|---|---|
| login.png | Ảnh màn hình đăng nhập |
| dashboard.png | Icon dashboard |
| home.jpg | Ảnh nền chính |
| bookpackage.jpg, package1.jpg, package2.jpg, package3.jpg | Ảnh gói du lịch |
| book.jpg | Ảnh đặt khách sạn |
| hotel1.jpg...hotel10.jpg | Ảnh khách sạn |
| dest1.jpg...dest9.jpg | Ảnh điểm đến |
| newcustomer.jpg | Ảnh thêm khách |

### 4. Build và chạy

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="org.example.App"
```

Hoặc chạy JAR đã đóng gói:
```bash
mvn package
java -jar target/TravelandTourismManagementSystem-1.0-SNAPSHOT.jar
```

## Schema Database

### Bảng `account`
| Cột | Kiểu | Mô tả |
|---|---|---|
| username | VARCHAR(20) PK | Tên đăng nhập |
| name | VARCHAR(50) | Họ tên |
| password | VARCHAR(20) | Mật khẩu |
| security_question | VARCHAR(100) | Câu hỏi bảo mật |
| answer | VARCHAR(100) | Câu trả lời |

### Bảng `customer`
Thông tin cá nhân: username, id_type, number, name, gender, address, phone, email

### Bảng `bookpackage`
Lưu các gói đã đặt: username, package, persons, id, number, phone, price

### Bảng `hotel`
Danh sách khách sạn: name PK, cost_per_person, ac_room, food_included

### Bảng `bookhotel`
Lưu các phòng đã đặt: username, name, persons, days, ac, food, id, number, phone, price

## Đăng nhập mặc định

| Username | Password |
|---|---|
| admin | 123456 |
| nguyenvana | *(đăng ký tài khoản mới)* |