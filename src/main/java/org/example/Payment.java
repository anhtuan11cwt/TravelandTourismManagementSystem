package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener {

    JButton pay, back;

    public Payment() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/paytm.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 600);
        add(image);

        pay = new JButton("Thanh toán");
        pay.setBounds(420, 20, 80, 40);
        pay.addActionListener(this);
        image.add(pay);

        back = new JButton("Quay lại");
        back.setBounds(520, 20, 80, 40);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == pay) {
            new Paytm();
            setVisible(false);
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment();
    }
}
