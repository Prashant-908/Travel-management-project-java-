package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, password;
    JTextField tfusername;
    JPasswordField tfpassword;

    Login() {
        setSize(850, 400);
        setLocation(350, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        // Left Panel
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131, 193, 233));
        p1.setBounds(0, 0, 400, 400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120, 200, 200);
        p1.add(image);

        // Right Panel
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400, 30, 400, 300);
        add(p2);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 20, 100, 25);
        lblusername.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(60, 60, 300, 30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(60, 110, 100, 25);
        lblpassword.setFont(new Font("SAN SERIF", Font.PLAIN, 20));
        p2.add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(60, 150, 300, 30);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpassword);

        login = new JButton("Login");
        login.setBounds(60, 190, 130, 30);
        login.setBackground(new Color(131, 193, 233));
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230, 190, 130, 30);
        signup.setBackground(new Color(131, 193, 233));
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        p2.add(signup);

        password = new JButton("Forget Password");
        password.setBounds(130, 250, 150, 30);
        password.setBackground(new Color(131, 193, 233));
        password.setForeground(Color.WHITE);
        password.addActionListener(this);
        p2.add(password);

        JLabel text = new JLabel("Trouble in Login?");
        text.setBounds(290, 250, 150, 20);
        p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            try {
                String username = tfusername.getText();
                String pass = new String(tfpassword.getPassword());

                String query = "SELECT * FROM data WHERE username='" + username + "' AND password='" + pass + "'";
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);

                if (rs.next()) {
                    UserSession.setUsername(username); // Store username globally
                    setVisible(false);
                    //new Loading(username); // Pass the username to Loading class
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred: " + e.getMessage());
                e.printStackTrace();
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        } else if (ae.getSource() == password) {
            String username = tfusername.getText();
            if (username.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter your username.");
            } else {
                // Password recovery logic
                JOptionPane.showMessageDialog(null, "Password recovery process initiated for " + username);
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
