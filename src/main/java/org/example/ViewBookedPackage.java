package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ViewBookedPackage extends JFrame {

    public ViewBookedPackage(String username) {
        setSize(900, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text = new JLabel("XEM CHI TIẾT GÓI ĐÃ ĐẶT");
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        text.setBounds(330, 10, 300, 30);
        add(text);

        JLabel lblusername = new JLabel("Tên đăng nhập");
        lblusername.setBounds(30, 100, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 100, 150, 25);
        add(labelusername);

        JLabel lblpackage = new JLabel("Tên gói");
        lblpackage.setBounds(30, 140, 150, 25);
        add(lblpackage);

        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220, 140, 200, 25);
        add(labelpackage);

        JLabel lblpersons = new JLabel("Số người");
        lblpersons.setBounds(30, 180, 150, 25);
        add(lblpersons);

        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220, 180, 150, 25);
        add(labelpersons);

        JLabel lblid = new JLabel("Mã");
        lblid.setBounds(30, 220, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 220, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Số điện thoại");
        lblnumber.setBounds(30, 260, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 260, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Điện thoại");
        lblphone.setBounds(30, 300, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(220, 300, 150, 25);
        add(labelphone);

        JLabel lblprice = new JLabel("Giá");
        lblprice.setBounds(30, 340, 150, 25);
        add(lblprice);

        JLabel labelprice = new JLabel();
        labelprice.setBounds(220, 340, 150, 25);
        add(labelprice);

        JButton back = new JButton("Quay lại");
        back.setBounds(130, 410, 100, 25);
        back.addActionListener(e -> setVisible(false));
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 70, 400, 350);
        add(image);

        try {
            Conn c = new Conn();
            String query = "select * from bookPackage where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("package"));
                labelpersons.setText(rs.getString("persons"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
                labelprice.setText(rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }
}
