package org.example;

import javax.swing.*;
import java.awt.*;

public class Destinations extends JFrame implements Runnable {

    Thread th;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
    JLabel[] label = new JLabel[]{l1, l2, l3, l4, l5, l6, l7, l8, l9};

    public void run() {
        try {
            for (int i = 0; i < 9; i++) {
                label[i].setVisible(true);
                Thread.sleep(2500);
                label[i].setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Destinations() {
        setSize(800, 600);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = null, i2 = null, i3 = null, i4 = null, i5 = null, i6 = null, i7 = null, i8 = null, i9 = null;
        ImageIcon[] image = new ImageIcon[]{i1, i2, i3, i4, i5, i6, i7, i8, i9};

        Image j1 = null, j2 = null, j3 = null, j4 = null, j5 = null, j6 = null, j7 = null, j8 = null, j9 = null;
        Image[] jimage = new Image[]{j1, j2, j3, j4, j5, j6, j7, j8, j9};

        ImageIcon i11 = null, i12 = null, i13 = null, i14 = null, i15 = null, i16 = null, i17 = null, i18 = null, i19 = null;
        ImageIcon[] iimage = new ImageIcon[]{i11, i12, i13, i14, i15, i16, i17, i18, i19};

        for (int i = 0; i < 9; i++) {
            String[] extensions = {".jpg", ".jpeg", ".png"};
            java.net.URL imgUrl = null;
            for (String ext : extensions) {
                imgUrl = ClassLoader.getSystemResource("icons/dest" + (i + 1) + ext);
                if (imgUrl != null) break;
            }
            
            if (imgUrl != null) {
                image[i] = new ImageIcon(imgUrl);
            } else {
                System.err.println("Could not find image for: dest" + (i + 1));
                continue; // Hoặc xử lý lỗi phù hợp
            }
            jimage[i] = image[i].getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
            iimage[i] = new ImageIcon(jimage[i]);
            label[i] = new JLabel(iimage[i]);
            label[i].setBounds(0, 0, 800, 600);
            add(label[i]);
            label[i].setVisible(false);
        }

        th = new Thread(this);
        th.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        new Destinations();
    }
}
