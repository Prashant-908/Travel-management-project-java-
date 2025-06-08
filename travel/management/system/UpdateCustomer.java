package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener {
    JLabel labelusername, labelname;
    JComboBox comboid;
    JTextField tfnumber, tfcountry, tfaddress, tfemail, tfphone;
    JRadioButton rmale, rfemale;
    JButton add, back;

    UpdateCustomer(String username) {
        setBounds(250, 60, 800, 530);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel text = new JLabel("UPDATE CUSTOMER DETAILS");
        text.setBounds(50 ,0, 300,25);
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel id = new JLabel("ID");
        id.setBounds(30, 90, 150, 25);
        add(id);

        comboid = new JComboBox(new String[]{"Passport", "Aadhar Card", "Pan Card"});
        comboid.setBounds(220, 90, 150, 25);
        comboid.setBackground(Color.WHITE);
        add(comboid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 130, 150, 25);
        add(lblnumber);

        tfnumber = new JTextField();
        tfnumber.setBounds(220, 130, 150, 25);
        add(tfnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 170, 150, 25);
        add(lblname);

        labelname = new JLabel();
        labelname.setBounds(220, 170, 150, 25);
        add(labelname);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(30, 210, 150, 25);
        add(gender);

        rmale = new JRadioButton("Male");
        rmale.setBounds(220, 210, 70, 25);
        rmale.setBackground(Color.WHITE);
        add(rmale);

        rfemale = new JRadioButton("Female");
        rfemale.setBounds(300, 210, 70, 25);
        rfemale.setBackground(Color.WHITE);
        add(rfemale);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rmale);
        bg.add(rfemale);

        JLabel co = new JLabel("Country");
        co.setBounds(30, 250, 150, 25);
        add(co);

        tfcountry = new JTextField();
        tfcountry.setBounds(220, 250, 150, 25);
        add(tfcountry);

        JLabel ad = new JLabel("Address");
        ad.setBounds(30, 290, 150, 25);
        add(ad);

        tfaddress = new JTextField();
        tfaddress.setBounds(220, 290, 150, 25);
        add(tfaddress);

        JLabel phone = new JLabel("Phone No.");
        phone.setBounds(30, 330, 150, 25);
        add(phone);

        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);

        JLabel email = new JLabel("Email");
        email.setBounds(30, 370, 150, 25);
        add(email);

        tfemail = new JTextField();
        tfemail.setBounds(220, 370, 150, 25);
        add(tfemail);

        add = new JButton("Add");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(70, 430, 100, 25);
        add.addActionListener(this);
        add(add);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220, 430, 100, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 40, 400, 420);
        add(image);

        // Fetch user data
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM data WHERE username = '" +username+ "'");
            if (rs.next()) {
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
            } else {
                JOptionPane.showMessageDialog(null, "User not found in database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String id = (String) comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = null;
            if (rmale.isSelected()) {
                gender = "Male";
            } else if (rfemale.isSelected()) {
                gender = "Female";
            }
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String username = labelusername.getText();

            try {
                Conn c = new Conn();
                String query = "INSERT INTO customer (username, id, number, name, gender, country, address, phone, email) VALUES ('" + username + "', '" + id + "', '" + number + "', '" + name + "', '" + gender + "', '" + country + "', '" + address + "', '" + phone + "', '" + email + "')";
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        String username = UserSession.getUsername(); // Get username here in main method
        new UpdateCustomer("pranay");
    }
}
