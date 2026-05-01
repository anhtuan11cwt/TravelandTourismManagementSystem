package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener {

    public About() {
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("VỀ DỰ ÁN");
        l1.setBounds(200, 10, 200, 40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(l1);

        String s = "Hệ thống Quản lý Du lịch và Du ngoạn \n\n" +
                   "Dự án này được thiết kế để quản lý toàn bộ quy trình đặt tour và khách sạn.\n" +
                   "Tính năng bao gồm:\n" +
                   "- Quản lý khách hàng\n" +
                   "- Đặt gói tour du lịch\n" +
                   "- Đặt phòng khách sạn\n" +
                   "- Hệ thống thanh toán trực tuyến\n" +
                   "- Tích hợp công cụ tiện ích (Máy tính, Sổ tay)";
        
        TextArea t1 = new TextArea(s, 10, 40, TextArea.SCROLLBARS_VERTICAL_ONLY);
        t1.setEditable(false);
        t1.setBounds(50, 60, 500, 300);
        add(t1);

        JButton back = new JButton("Quay lại");
        back.setBounds(250, 400, 100, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new About();
    }
}
