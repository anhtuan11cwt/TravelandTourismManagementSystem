package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCustomer extends JFrame implements ActionListener {

    JTextField tfID, tfNumber, tfGender, tfAddress, tfPhone, tfEmail;
    JButton update, back;
    JLabel lblUsername, lblName;
    String username;

    UpdateCustomer(String username) {
        this.username = username;
        setSize(850, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text = new JLabel("CẬP NHẬT THÔNG TIN KHÁCH HÀNG");
        text.setBounds(50, 0, 300, 25);
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(text);

        // Username
        JLabel lbl = new JLabel("Tên đăng nhập");
        lbl.setBounds(30, 50, 150, 25);
        add(lbl);

        lblUsername = new JLabel();
        lblUsername.setBounds(220, 50, 150, 25);
        add(lblUsername);

        // ID
        JLabel lblid = new JLabel("Loại giấy tờ");
        lblid.setBounds(30, 90, 150, 25);
        add(lblid);

        tfID = new JTextField();
        tfID.setBounds(220, 90, 150, 25);
        add(tfID);

        // Number
        JLabel lblnumber = new JLabel("Số giấy tờ");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfNumber = new JTextField();
        tfNumber.setBounds(220, 130, 150, 25);
        add(tfNumber);

        // Name
        JLabel lblname = new JLabel("Tên");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        lblName = new JLabel();
        lblName.setBounds(220, 170, 150, 25);
        add(lblName);

        // Gender
        JLabel lblgender = new JLabel("Giới tính");
        lblgender.setBounds(30, 210, 150, 25);
        add(lblgender);

        tfGender = new JTextField();
        tfGender.setBounds(220, 210, 150, 25);
        add(tfGender);

        // Address
        JLabel lbladdress = new JLabel("Địa chỉ");
        lbladdress.setBounds(30, 250, 150, 25);
        add(lbladdress);

        tfAddress = new JTextField();
        tfAddress.setBounds(220, 250, 150, 25);
        add(tfAddress);

        // Phone
        JLabel lblphone = new JLabel("Điện thoại");
        lblphone.setBounds(30, 290, 150, 25);
        add(lblphone);

        tfPhone = new JTextField();
        tfPhone.setBounds(220, 290, 150, 25);
        add(tfPhone);

        // Email
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 330, 150, 25);
        add(lblemail);

        tfEmail = new JTextField();
        tfEmail.setBounds(220, 330, 150, 25);
        add(tfEmail);

        // Buttons
        update = new JButton("Cập nhật");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 390, 100, 25);
        update.addActionListener(this);
        add(update);

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 390, 100, 25);
        back.addActionListener(this);
        add(back);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 200, 200);
        add(image);

        // Load existing data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer where username = '" + username + "'");
            while(rs.next()) {
                lblUsername.setText(rs.getString("username"));
                lblName.setText(rs.getString("name"));
                tfID.setText(rs.getString("id_type"));
                tfNumber.setText(rs.getString("number"));
                tfGender.setText(rs.getString("gender"));
                tfAddress.setText(rs.getString("address"));
                tfPhone.setText(rs.getString("phone"));
                tfEmail.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            String username = lblUsername.getText();
            String id = tfID.getText();
            String number = tfNumber.getText();
            String name = lblName.getText();
            String gender = tfGender.getText();
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();

            String query = "update customer set id_type = '" + id + "', number = '" + number + "', name = '" + name + "', gender = '" + gender + "', address = '" + address + "', phone = '" + phone + "', email = '" + email + "' where username = '" + username + "'";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Cập nhật thông tin khách hàng thành công");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateCustomer("admin");
    }
}
