package org.example;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, password;
    JTextField tfUsername, tfPassword;

    Login() {
        setSize(900, 400);
        setLocationRelativeTo(null);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Panel p1: Left side with image
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        // Panel p2: Right side with form
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 450, 300);
        add(p2);

        JLabel lblUsername = new JLabel("Tên đăng nhập");
        lblUsername.setBounds(60, 20, 200, 25);
        lblUsername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblUsername);

        tfUsername = new JTextField();
        tfUsername.setBounds(60, 60, 300, 30);
        tfUsername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfUsername);

        JLabel lblPassword = new JLabel("Mật khẩu");
        lblPassword.setBounds(60, 110, 200, 25);
        lblPassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblPassword);

        tfPassword = new JTextField();
        tfPassword.setBounds(60, 150, 300, 30);
        tfPassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfPassword);

        login = new JButton("Đăng nhập");
        login.setBounds(60, 200, 130, 30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(131, 193, 233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Đăng ký");
        signup.setBounds(230, 200, 130, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(131, 193, 233)));
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Quên mật khẩu");
        password.setBounds(130, 250, 130, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.WHITE);
        password.setBorder(new LineBorder(new Color(131, 193, 233)));
        password.addActionListener(this);
        p2.add(password);

        

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            // Future implementation
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup();
        } else if (ae.getSource() == password) {
            setVisible(false);
            new ForgotPassword();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
