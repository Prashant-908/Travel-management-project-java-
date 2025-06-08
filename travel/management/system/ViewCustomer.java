package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ViewCustomer extends JFrame {
    JButton back;

    ViewCustomer(String Username) {
        setBounds(250, 60, 870, 500);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setTitle("View Customer Details");

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30, 50, 150, 25);
        add(lblusername);

        JLabel labelusername = new JLabel("");
        labelusername.setBounds(220, 50, 150, 25);
        add(labelusername);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30, 110, 150, 25);
        add(lblid);

        JLabel labelid = new JLabel("");
        labelid.setBounds(220, 110, 150, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(30, 160, 150, 25);
        add(lblnumber);

        JLabel labelnumber = new JLabel("");
        labelnumber.setBounds(220, 160, 150, 25);
        add(labelnumber);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 220, 150, 25);
        add(lblname);

        JLabel labelname = new JLabel("");
        labelname.setBounds(220, 220, 150, 25);
        add(labelname);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(30, 280, 150, 25);
        add(lblgender);

        JLabel labelgender = new JLabel("");
        labelgender.setBounds(220, 280, 150, 25);
        add(labelgender);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(500, 50, 150, 25);
        add(lblcountry);

        JLabel labelcountry = new JLabel("");
        labelcountry.setBounds(690, 50, 150, 25);
        add(labelcountry);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(500, 110, 150, 25);
        add(lbladdress);

        JLabel labeladdress = new JLabel("");
        labeladdress.setBounds(690, 110, 150, 25);
        add(labeladdress);

        JLabel lblphoneno = new JLabel("Phone No.");
        lblphoneno.setBounds(500, 160, 150, 25);
        add(lblphoneno);

        JLabel labelphoneno = new JLabel("");
        labelphoneno.setBounds(690, 160, 150, 25);
        add(labelphoneno);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 220, 150, 25);
        add(lblemail);

        JLabel labelemail = new JLabel("");
        labelemail.setBounds(690, 220, 150, 25);
        add(labelemail);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350, 350, 100, 25);
        add(back);

        // 👉 ADDING ActionListener on Back Button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                setVisible(false); // Hide the window when Back is clicked
            }
        });

        // Uncomment if you want to add image later
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel image = new JLabel(i3);
        // image.setBounds(20, 400, 600, 200);
        // add(image);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where Username = '" + Username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelname.setText(rs.getString("Name"));
                labelgender.setText(rs.getString("Gender"));
                labelcountry.setText(rs.getString("Country"));
                labeladdress.setText(rs.getString("Address"));
                labelphoneno.setText(rs.getString("Phone"));
                labelemail.setText(rs.getString("Email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {

        new ViewCustomer("paras");
    }
}
