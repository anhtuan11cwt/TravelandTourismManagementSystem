CREATE DATABASE IF NOT EXISTS travelmanagementsystem;

USE travelmanagementsystem;

CREATE TABLE IF NOT EXISTS account (
    username VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    password VARCHAR(20),
    security_question VARCHAR(100),
    answer VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS customer (
    username VARCHAR(20),
    id_type VARCHAR(30),
    number VARCHAR(20),
    name VARCHAR(30),
    gender VARCHAR(10),
    address VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(40)
);

-- Thêm dữ liệu mẫu
INSERT IGNORE INTO account (username, name, password, security_question, answer) 
VALUES ('admin', 'Quản trị viên', '123456', 'Số may mắn của bạn', '7');

INSERT IGNORE INTO customer (username, id_type, number, name, gender, address, phone, email)
VALUES ('admin', 'Hộ chiếu', 'A12345678', 'Quản trị viên', 'Nam', 'Hà Nội', '0912345678', 'admin@travel.com'),
       ('nguyenvana', 'Hộ chiếu', 'B87654321', 'Nguyễn Văn A', 'Nam', 'Đà Nẵng', '0987654321', 'nguyenvana@example.com'),
       ('tranvanb', 'Hộ chiếu', 'C11223344', 'Trần Văn B', 'Nam', 'TP. Hồ Chí Minh', '0901234567', 'tranvanb@example.com'),
       ('lethic', 'Hộ chiếu', 'D55667788', 'Lê Thị C', 'Nữ', 'Cần Thơ', '0934567890', 'lethic@example.com'),
       ('phamvand', 'Hộ chiếu', 'E99887766', 'Phạm Văn D', 'Nam', 'Hải Phòng', '0978654321', 'phamvand@example.com');

CREATE TABLE IF NOT EXISTS bookpackage (
    username VARCHAR(20),
    package VARCHAR(30),
    persons VARCHAR(20),
    id VARCHAR(30),
    number VARCHAR(20),
    phone VARCHAR(20),
    price VARCHAR(20)
);

INSERT IGNORE INTO bookpackage (username, package, persons, id, number, phone, price)
VALUES ('admin', 'Gói Vàng', '2', 'Hộ chiếu', 'A12345678', '0912345678', '24000 VND'),
       ('nguyenvana', 'Gói Bạc', '1', 'Hộ chiếu', 'B87654321', '0987654321', '25000 VND');
