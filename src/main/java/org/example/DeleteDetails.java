package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class DeleteDetails extends JFrame implements ActionListener {

    JButton delete, back;
    String username;

    public DeleteDetails(String username) {
        this.username = username;
        setSize(450, 400);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel lblUsername = new JLabel("Tên đăng nhập:");
        lblUsername.setBounds(30, 50, 150, 25);
        add(lblUsername);

        JLabel labelUsername = new JLabel(username);
        labelUsername.setBounds(200, 50, 150, 25);
        add(labelUsername);

        delete = new JButton("Xóa");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(80, 250, 100, 30);
        delete.addActionListener(this);
        add(delete);

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250, 250, 100, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("delete from account where username = '" + username + "'");
                c.s.executeUpdate("delete from customer where username = '" + username + "'");
                c.s.executeUpdate("delete from bookpackage where username = '" + username + "'");
                c.s.executeUpdate("delete from bookhotel where username = '" + username + "'");
                
                JOptionPane.showMessageDialog(null, "Xóa dữ liệu thành công");
                System.exit(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new DeleteDetails("admin");
    }
}
