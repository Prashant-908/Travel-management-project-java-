package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Loading extends JFrame implements Runnable {
    Thread t;
    JProgressBar bar;
    String username;

    public JProgressBar getBar() {
        return bar;
    }

    public void run() {
        try {
            for (int i = 1; i <= 100; i++) {
                int max = bar.getMaximum();
                int value = bar.getValue();

                if (value < max) {
                    bar.setValue(value + 1);
                } else {
                    setVisible(false);
                    new Dashboard(username);
                }

                Thread.sleep(50);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Loading(String username) {
        this.username = username;
        t = new Thread(this);
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel p1 = new JLabel("GoFly: Fly To New Place");
        p1.setBounds(50, 20, 600, 30);
        p1.setForeground(Color.CYAN);
        p1.setFont(new Font("Raleway", Font.BOLD, 30));
        add(p1);

        // Fixed the string concatenation here
        JLabel lblusername = new JLabel("Welcome " + username);
        lblusername.setBounds(20, 310, 400, 30);
        lblusername.setForeground(Color.RED);
        lblusername.setFont(new Font("Raleway", Font.BOLD, 20));
        add(lblusername);

        JLabel text = new JLabel("Please Wait.....");
        text.setBounds(200, 120, 200, 20);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);

        // Corrected: Assign to class-level 'bar', not a new local variable
        bar = new JProgressBar();
        bar.setBounds(150, 90, 300, 25);
        bar.setStringPainted(true);
        add(bar);

        t.start();

        setVisible(true);
    }

    public static void main(String[] args) {
        // Provide the username here when creating the Loading screen
        new Loading("");  // Example u
    }
}