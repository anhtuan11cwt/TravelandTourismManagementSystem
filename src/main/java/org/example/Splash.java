package org.example;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable {
    Thread thread;

    public Splash() {
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/splash.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        setVisible(true);

        int x = 1;
        for (int i = 1; i <= 500; x += 7, i += 6) {
            setSize(x + i, i);
            // Built-in method to center the frame relative to the screen (when passing null)
            setLocationRelativeTo(null); 
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            Thread.sleep(7000);
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Splash();
    }
}
