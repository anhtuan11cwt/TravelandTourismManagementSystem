package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewBookedHotel extends JFrame implements ActionListener {

    JButton back;

    public ViewBookedHotel(String username) {
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("CHI TIẾT ĐẶT KHÁCH SẠN");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(350, 10, 300, 30);
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        JLabel labelUsername = new JLabel();
        labelUsername.setBounds(250, 50, 200, 25);
        add(labelUsername);

        JLabel lblHotel = new JLabel("Tên khách sạn");
        lblHotel.setBounds(30, 90, 150, 25);
        add(lblHotel);

        JLabel labelHotel = new JLabel();
        labelHotel.setBounds(250, 90, 200, 25);
        add(labelHotel);

        JLabel lblPersons = new JLabel("Số người");
        lblPersons.setBounds(30, 130, 150, 25);
        add(lblPersons);

        JLabel labelPersons = new JLabel();
        labelPersons.setBounds(250, 130, 200, 25);
        add(labelPersons);

        JLabel lblDays = new JLabel("Số ngày lưu trú");
        lblDays.setBounds(30, 170, 150, 25);
        add(lblDays);

        JLabel labelDays = new JLabel();
        labelDays.setBounds(250, 170, 200, 25);
        add(labelDays);

        JLabel lblAC = new JLabel("Phòng AC/Non-AC");
        lblAC.setBounds(30, 210, 150, 25);
        add(lblAC);

        JLabel labelAC = new JLabel();
        labelAC.setBounds(250, 210, 200, 25);
        add(labelAC);

        JLabel lblFood = new JLabel("Bao gồm đồ ăn");
        lblFood.setBounds(30, 250, 150, 25);
        add(lblFood);

        JLabel labelFood = new JLabel();
        labelFood.setBounds(250, 250, 200, 25);
        add(labelFood);

        JLabel lblId = new JLabel("Loại ID");
        lblId.setBounds(30, 290, 150, 25);
        add(lblId);

        JLabel labelId = new JLabel();
        labelId.setBounds(250, 290, 200, 25);
        add(labelId);

        JLabel lblNumber = new JLabel("Số ID");
        lblNumber.setBounds(30, 330, 150, 25);
        add(lblNumber);

        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(250, 330, 200, 25);
        add(labelNumber);

        JLabel lblPhone = new JLabel("Số điện thoại");
        lblPhone.setBounds(30, 370, 150, 25);
        add(lblPhone);

        JLabel labelPhone = new JLabel();
        labelPhone.setBounds(250, 370, 200, 25);
        add(labelPhone);

        JLabel lblTotal = new JLabel("Tổng chi phí");
        lblTotal.setBounds(30, 410, 150, 25);
        add(lblTotal);

        JLabel labelPrice = new JLabel();
        labelPrice.setBounds(250, 410, 200, 25);
        add(labelPrice);

        try {
            Conn c = new Conn();
            String query = "select * from bookhotel where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelHotel.setText(rs.getString("name"));
                labelPersons.setText(rs.getString("persons"));
                labelDays.setText(rs.getString("days"));
                labelAC.setText(rs.getString("ac"));
                labelFood.setText(rs.getString("food"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
                labelPrice.setText(rs.getString("price"));
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy dữ liệu đặt phòng");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130, 480, 120, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 500, 400);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewBookedHotel("admin");
    }
}
