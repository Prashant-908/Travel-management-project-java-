package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener {

    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
    JButton checkprice, bookpackage, back;

    BookPackage(String username) {
        this.username = username;
        setBounds(250, 80, 900, 500);
        setLayout(null);

        JLabel text = new JLabel("BOOK PACKAGE");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 150, 20);
        add(labelusername);

        JLabel lblselect = new JLabel("Select Package");
        lblselect.setBounds(40, 110, 200, 20);
        add(lblselect);

        cpackage = new Choice();
        cpackage.add("GOLD PACKAGE");
        cpackage.add("SILVER PACKAGE");
        cpackage.add("BRONZE PACKAGE");
        cpackage.setBounds(250, 110, 200, 20);
        add(cpackage);

        JLabel lbltnumber = new JLabel("Total Persons");
        lbltnumber.setBounds(40, 150, 150, 25);
        add(lbltnumber);

        tfpersons = new JTextField("1");
        tfpersons.setBounds(250, 150, 200, 20);
        add(tfpersons);

        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40, 190, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 190, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 230, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 230, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 270, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 270, 150, 25);
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setBounds(40, 310, 150, 25);
        add(lbltotalprice);

        labeltotal = new JLabel();
        labeltotal.setBounds(250, 310, 150, 25);
        add(labeltotal);

        try {
            Conn conn = new Conn();
            String query = "select * from customer where Username = '" + username + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelusername.setText(rs.getString("Username"));
                labelid.setText(rs.getString("Id"));
                labelnumber.setText(rs.getString("Number"));
                labelphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60, 380, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 380, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 380, 120, 25);
        back.addActionListener(this);
        add(back);


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            String pack = cpackage.getSelectedItem();
            int cost = 0;

            if (pack.equals("GOLD PACKAGE")) {
                cost = 12000;
            } else if (pack.equals("SILVER PACKAGE")) {
                cost = 8000;
            } else {
                cost = 5000;
            }

            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labeltotal.setText(String.valueOf(cost));

        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                String query = "insert into book values('"
                        + labelusername.getText() + "','"
                        + cpackage.getSelectedItem() + "','"
                        + tfpersons.getText() + "','"
                        + labelid.getText() + "','"
                        + labelnumber.getText() + "','"
                        + labelphone.getText() + "','"
                        + labeltotal.getText() + "')";

                c.s.executeUpdate(query); // Corrected from executeQuery to executeUpdate
                JOptionPane.showMessageDialog(null, "Package Booked Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPackage("paras");
    }
}
