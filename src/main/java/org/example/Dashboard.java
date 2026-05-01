package org.example;

import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    String username;

    public Dashboard(String username) {
        this.username = username;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setLayout(null);

        // Top Panel
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Bảng điều khiển");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // Side Panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        JButton[] buttons = {
            new JButton("Thêm thông tin cá nhân"),
            new JButton("Cập nhật thông tin"),
            new JButton("Xem thông tin"),
            new JButton("Xóa thông tin"),
            new JButton("Kiểm tra gói du lịch"),
            new JButton("Đặt gói du lịch"),
            new JButton("Xem gói du lịch"),
            new JButton("Xem khách sạn"),
            new JButton("Đặt khách sạn"),
            new JButton("Xem phòng đã đặt"),
            new JButton("Xem gói đã đặt"),
            new JButton("Điểm đến"),
            new JButton("Thanh toán"),
            new JButton("Máy tính"),
            new JButton("Ghi chú"),
            new JButton("Thông tin")
        };

        buttons[4].addActionListener(e -> new CheckPackage());
        buttons[5].addActionListener(e -> new BookPackage(username));
        buttons[0].addActionListener(e -> new AddCustomer(username));
        buttons[1].addActionListener(e -> new UpdateCustomer(username));
        buttons[2].addActionListener(e -> new ViewCustomer(username));
        buttons[10].addActionListener(e -> new ViewBookedPackage(username));

        int y = 0;
        for (JButton btn : buttons) {
            btn.setBounds(0, y, 300, 50);
            btn.setBackground(new Color(0, 0, 102));
            btn.setForeground(Color.WHITE);
            btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
            btn.setMargin(new Insets(0, 0, 0, 60));
            p2.add(btn);
            y += 50;
        }

        // Main Image Area
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650, 1000, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0, 0, 1650, 1000);
        add(image);

        JLabel text = new JLabel("Hệ thống Quản lý Du lịch và Du ngoạn");
        text.setBounds(400, 70, 1000, 70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.PLAIN, 55));
        image.add(text);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Dashboard("admin");
    }
}
