package org.example;

import javax.swing.*;
import java.awt.*;

public class CheckPackage extends JFrame {

    public CheckPackage() {
        setSize(900, 600);
        setLocationRelativeTo(null);
        setLayout(null);

        String[] package1 = new String[]{"GÓI VÀNG", "6 ngày 7 đêm", "Đón sân bay", "Tour thành phố", "Hướng dẫn viên tiếng Anh", "Vé vào cửa các điểm tham quan", "Ăn sáng và tối", "Miễn phí Wifi", "12000/-", "icons/package1.jpg"};
        String[] package2 = new String[]{"GÓI BẠC", "4 ngày 5 đêm", "Đón sân bay", "Tour thành phố", "Hướng dẫn viên tiếng Anh", "Vé vào cửa", "Ăn sáng", "Miễn phí Wifi", "25000/-", "icons/package2.jpg"};
        String[] package3 = new String[]{"GÓI ĐỒNG", "2 ngày 3 đêm", "Đón sân bay", "Hướng dẫn viên tiếng Anh", "Vé vào cửa", "Ăn sáng", "15000/-", "icons/package3.jpg"};

        JTabbedPane tab = new JTabbedPane();
        
        JPanel p1 = createPackage(package1);
        tab.addTab("Gói Vàng", null, p1);
        
        JPanel p2 = createPackage(package2);
        tab.addTab("Gói Bạc", null, p2);
        
        JPanel p3 = createPackage(package3);
        tab.addTab("Gói Đồng", null, p3);

        tab.setSize(900, 600);
        tab.setLocation(0, 0);
        add(tab);
        
        setVisible(true);
    }

    public JPanel createPackage(String[] pack) {
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        p1.setPreferredSize(new Dimension(900, 600));

        JLabel l1 = new JLabel(pack[0]);
        l1.setSize(300, 30);
        l1.setLocation(50, 20);
        l1.setForeground(Color.YELLOW);
        l1.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(l1);

        int y = 60;
        for (int i = 1; i < pack.length - 2; i++) {
            JLabel l = new JLabel(pack[i]);
            l.setSize(300, 30);
            l.setLocation(30, y);
            l.setForeground(Color.RED);
            l.setFont(new Font("Tahoma", Font.PLAIN, 20));
            p1.add(l);
            y += 30;
        }

        JLabel lprice = new JLabel(pack[pack.length - 2]);
        lprice.setSize(300, 30);
        lprice.setLocation(50, p1.getHeight() - 50);
        lprice.setForeground(Color.BLUE);
        lprice.setFont(new Font("Tahoma", Font.BOLD, 25));
        p1.add(lprice);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource(pack[pack.length - 1]));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setSize(500, 300);
        image.setLocation(p1.getWidth() - 520, 20);
        p1.add(image);

        return p1;
    }

    public static void main(String[] args) {
        new CheckPackage();
    }
}
