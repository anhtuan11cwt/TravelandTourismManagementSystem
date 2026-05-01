package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelUsername, labelId, labelNumber, labelPhone, labelPrice;
    JButton checkPrice, bookPackage, back;

    public BookPackage(String username) {
        this.username = username;
        setSize(1100, 450);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("ĐẶT GÓI DU LỊCH");
        text.setBounds(400, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 70, 100, 20);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(250, 70, 200, 20);
        labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelUsername);

        JLabel lblPackage = new JLabel("Chọn Gói");
        lblPackage.setBounds(40, 110, 100, 20);
        lblPackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPackage);

        cpackage = new Choice();
        cpackage.add("Gói Vàng");
        cpackage.add("Gói Bạc");
        cpackage.add("Gói Đồng");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        JLabel lblPersons = new JLabel("Số người");
        lblPersons.setBounds(40, 150, 100, 20);
        lblPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 20);
        add(tfpersons);

        JLabel lblId = new JLabel("Loại ID");
        lblId.setBounds(40, 190, 100, 20);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(250, 190, 200, 20);
        add(labelId);

        JLabel lblNumber = new JLabel("Số ID");
        lblNumber.setBounds(40, 230, 100, 20);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(250, 230, 200, 20);
        add(labelNumber);

        JLabel lblPhone = new JLabel("Số điện thoại");
        lblPhone.setBounds(40, 270, 100, 20);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250, 270, 200, 20);
        add(labelPhone);

        JLabel lblTotal = new JLabel("Tổng giá");
        lblTotal.setBounds(40, 310, 100, 20);
        lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotal);

        labelPrice = new JLabel();
        labelPrice.setBounds(250, 310, 200, 20);
        labelPrice.setForeground(Color.RED);
        add(labelPrice);

        try {
            Conn c = new Conn();
            String query = "select * from customer where username = '" + username + "'";
            ResultSet rs = c.s.executeQuery(query);
            while (rs.next()) {
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id_type"));
                labelNumber.setText(rs.getString("number"));
                labelPhone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkPrice = new JButton("Kiểm tra giá");
        checkPrice.setBackground(Color.BLACK);
        checkPrice.setForeground(Color.WHITE);
        checkPrice.setBounds(60, 380, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookPackage = new JButton("Đặt gói");
        bookPackage.setBackground(Color.BLACK);
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setBounds(200, 380, 120, 25);
        bookPackage.addActionListener(this);
        add(bookPackage);

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(550, 50, 500, 300);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkPrice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            if (pack.equals("Gói Vàng")) {
                cost += 12000;
            } else if (pack.equals("Gói Bạc")) {
                cost += 25000;
            } else {
                cost += 15000;
            }
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelPrice.setText(cost + " VND");
        } else if (ae.getSource() == bookPackage) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+labelUsername.getText()+"', '"+cpackage.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+labelId.getText()+"', '"+labelNumber.getText()+"', '"+labelPhone.getText()+"', '"+labelPrice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Đặt gói thành công");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("admin");
    }
}
