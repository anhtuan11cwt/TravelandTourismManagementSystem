package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddCustomer extends JFrame implements ActionListener {

    JTextField tfNumber, tfAddress, tfPhone, tfEmail;
    JComboBox<String> comboid;
    JRadioButton rmale, rfemale;
    JButton add, back;
    JLabel lblUsername, lblName;
    String username;

    AddCustomer(String username) {
        this.username = username;
        setSize(850, 550);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

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

        comboid = new JComboBox<>(new String[] {"Hộ chiếu", "Thẻ căn cước", "Mã số thuế", "Sổ hộ khẩu"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

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

        rmale = new JRadioButton("Nam");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Nữ");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

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
        add = new JButton("Thêm");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 420, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Quay lại");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 420, 100, 25);
        back.addActionListener(this);
        add(back);

        // Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 40, 400, 330);
        add(image);

        // Pre-fill data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from account where username = '" + username + "'");
            while(rs.next()) {
                lblUsername.setText(rs.getString("username"));
                lblName.setText(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String username = lblUsername.getText();
            String id = (String) comboid.getSelectedItem();
            String number = tfNumber.getText();
            String name = lblName.getText();
            String gender = rmale.isSelected() ? "Nam" : "Nữ";
            String address = tfAddress.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();

            String query = "insert into customer values('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + address + "', '" + phone + "', '" + email + "')";
            
            try {
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Thêm thông tin khách hàng thành công");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddCustomer("admin");
    }
}
