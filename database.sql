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
    country VARCHAR(20),
    address VARCHAR(50),
    phone VARCHAR(20),
    email VARCHAR(40)
);

-- Thêm dữ liệu mẫu
INSERT IGNORE INTO account (username, name, password, security_question, answer) 
VALUES ('admin', 'Quản trị viên', '123456', 'Số may mắn của bạn', '7');

INSERT IGNORE INTO customer (username, id_type, number, name, gender, country, address, phone, email)
VALUES ('admin', 'Hộ chiếu', 'A12345678', 'Quản trị viên', 'Nam', 'Việt Nam', 'Hà Nội', '0912345678', 'admin@travel.com');
