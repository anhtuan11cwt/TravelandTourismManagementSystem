package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;

    public ViewCustomer(String username) {
        setSize(870, 625);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("Tên đăng nhập");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("CMND/CCCD");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel();
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Số CMND");
        lblnumber.setBounds(30, 170, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220, 170, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Họ tên");
        lblname.setBounds(30, 230, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(220, 230, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Giới tính");
        lblgender.setBounds(30, 290, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel();
        labelgender.setBounds(220, 290, 150, 25);
        add(labelgender);

        JLabel lbladdress = new JLabel("Địa chỉ");
        lbladdress.setBounds(500, 50, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(690, 50, 150, 25);
        add(labeladdress);

        JLabel lblphone = new JLabel("Điện thoại");
        lblphone.setBounds(500, 110, 150, 25);
        add(lblphone);

        JLabel labelphone = new JLabel();
        labelphone.setBounds(690, 110, 150, 25);
        add(labelphone);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 170, 150, 25);
        add(lblemail);

        JLabel labelemail = new JLabel();
        labelemail.setBounds(690, 170, 150, 25);
        add(labelemail);

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 400, 600, 200);
        add(image);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id_type"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewCustomer("admin");
    }
}
