package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel, cac, cfood;
    JTextField tfpersons, tfdays;
    String username;
    JLabel labelUsername, labelId, labelNumber, labelPhone, labelPrice;
    JButton checkPrice, bookHotel, back;

    public BookHotel(String username) {
        this.username = username;
        setSize(1100, 600);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("ĐẶT KHÁCH SẠN");
        text.setBounds(400, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(40, 70, 150, 20);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblUsername);

        labelUsername = new JLabel();
        labelUsername.setBounds(250, 70, 200, 20);
        labelUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelUsername);

        JLabel lblHotel = new JLabel("Chọn khách sạn");
        lblHotel.setBounds(40, 110, 150, 20);
        lblHotel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblHotel);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblPersons = new JLabel("Tổng số người");
        lblPersons.setBounds(40, 150, 150, 20);
        lblPersons.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPersons);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 20);
        add(tfpersons);

        JLabel lblDays = new JLabel("Số ngày lưu trú");
        lblDays.setBounds(40, 190, 150, 20);
        lblDays.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblDays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 20);
        add(tfdays);

        JLabel lblAC = new JLabel("Phòng AC/Non-AC");
        lblAC.setBounds(40, 230, 150, 20);
        lblAC.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAC);

        cac = new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(250, 230, 200, 20);
        add(cac);

        JLabel lblFood = new JLabel("Bao gồm đồ ăn");
        lblFood.setBounds(40, 270, 150, 20);
        lblFood.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblFood);

        cfood = new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(250, 270, 200, 20);
        add(cfood);

        JLabel lblId = new JLabel("Loại ID");
        lblId.setBounds(40, 310, 150, 20);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblId);

        labelId = new JLabel();
        labelId.setBounds(250, 310, 200, 20);
        add(labelId);

        JLabel lblNumber = new JLabel("Số ID");
        lblNumber.setBounds(40, 350, 150, 20);
        lblNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblNumber);

        labelNumber = new JLabel();
        labelNumber.setBounds(250, 350, 200, 20);
        add(labelNumber);

        JLabel lblPhone = new JLabel("Số điện thoại");
        lblPhone.setBounds(40, 390, 150, 20);
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblPhone);

        labelPhone = new JLabel();
        labelPhone.setBounds(250, 390, 200, 20);
        add(labelPhone);

        JLabel lblTotal = new JLabel("Tổng giá tiền");
        lblTotal.setBounds(40, 430, 150, 20);
        lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblTotal);

        labelPrice = new JLabel();
        labelPrice.setBounds(250, 430, 200, 20);
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
        checkPrice.setBounds(60, 490, 120, 25);
        checkPrice.addActionListener(this);
        add(checkPrice);

        bookHotel = new JButton("Đặt khách sạn");
        bookHotel.setBackground(Color.BLACK);
        bookHotel.setForeground(Color.WHITE);
        bookHotel.setBounds(200, 490, 120, 25);
        bookHotel.addActionListener(this);
        add(bookHotel);

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l12 = new JLabel(i3);
        l12.setBounds(500, 50, 600, 400);
        add(l12);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkPrice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from hotel where name = '" + chotel.getSelectedItem() + "'");
                while (rs.next()) {
                    int cost = Integer.parseInt(rs.getString("cost_per_person"));
                    int food = Integer.parseInt(rs.getString("food_included"));
                    int ac = Integer.parseInt(rs.getString("ac_room"));

                    int persons = Integer.parseInt(tfpersons.getText());
                    int days = Integer.parseInt(tfdays.getText());

                    String acSelected = cac.getSelectedItem();
                    String foodSelected = cfood.getSelectedItem();

                    if (persons * days > 0) {
                        int total = 0;
                        total += acSelected.equals("AC") ? ac : 0;
                        total += foodSelected.equals("Yes") ? food : 0;
                        total += cost;
                        total = total * persons * days;
                        labelPrice.setText(total + " VND");
                    } else {
                        JOptionPane.showMessageDialog(null, "Nhập số liệu hợp lệ");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == bookHotel) {
            try {
                Conn c = new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+labelUsername.getText()+"', '"+chotel.getSelectedItem()+"', '"+tfpersons.getText()+"', '"+tfdays.getText()+"', '"+cac.getSelectedItem()+"', '"+cfood.getSelectedItem()+"', '"+labelId.getText()+"', '"+labelNumber.getText()+"', '"+labelPhone.getText()+"', '"+labelPrice.getText()+"')");
                
                JOptionPane.showMessageDialog(null, "Đặt khách sạn thành công");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("admin");
    }
}
