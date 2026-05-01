CREATE DATABASE IF NOT EXISTS travelmanagementsystem;

USE travelmanagementsystem;

CREATE TABLE IF NOT EXISTS account (
    username VARCHAR(20) PRIMARY KEY,
    name VARCHAR(50),
    password VARCHAR(20),
    security_question VARCHAR(100),
    answer VARCHAR(100)
);

-- Thêm dữ liệu mẫu
INSERT INTO account (username, name, password, security_question, answer) 
VALUES ('admin', 'Quản trị viên', '123456', 'Số may mắn của bạn', '7');
