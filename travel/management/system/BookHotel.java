package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener {

    Choice chotel ,ctype,cfood;
    JTextField tfdays,tfperson;
    String username;
    JLabel labelusername, labelid, labelnumber, labelphone, labeltotal;
    JButton checkprice, bookpackage, back;

    BookHotel(String username) {
        this.username = username;
        setBounds(200, 60, 1000, 580);
        setLayout(null);

        JLabel text = new JLabel("BOOK HOTEL");
        text.setBounds(100, 10, 200, 30);
        text.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(text);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(40, 70, 100, 20);
        add(lblusername);

        labelusername = new JLabel();
        labelusername.setBounds(250, 70, 150, 20);
        add(labelusername);

        JLabel lblselect = new JLabel("Select Hotel");
        lblselect.setBounds(40, 110, 200, 20);
        add(lblselect);

        chotel = new Choice();
        chotel.setBounds(250, 110, 200, 20);
        add(chotel);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM hotel");
            while (rs.next()) {
                chotel.add(rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblperson = new JLabel("Total Persons");
        lblperson.setBounds(40, 150, 150, 25);
        add(lblperson);

        tfperson = new JTextField("1");
        tfperson.setBounds(250, 150, 200, 20);
        add(tfperson);

        JLabel lbldays = new JLabel("Number of days");
        lbldays.setBounds(40, 190, 190, 25);
        add(lbldays);

        tfdays = new JTextField("1");
        tfdays.setBounds(250, 190, 200, 20);
        add(tfdays);

        JLabel lbltype = new JLabel("AC/Non AC");
        lbltype.setBounds(40, 230, 190, 25);
        add(lbltype);

        ctype = new Choice();
        ctype.setBounds(250, 230, 200, 20);
        ctype.add("AC");
        ctype.add(("Non-AC"));
        add(ctype);

        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(40, 270, 190, 25);
        add(lblfood);

        cfood = new Choice();
        cfood.setBounds(250, 270, 200, 20);
        cfood.add("YES");
        cfood.add(("NO"));
        add(cfood);





        JLabel lblid = new JLabel("ID");
        lblid.setBounds(40, 310, 150, 25);
        add(lblid);

        labelid = new JLabel();
        labelid.setBounds(250, 310, 200, 25);
        add(labelid);

        JLabel lblnumber = new JLabel("Number");
        lblnumber.setBounds(40, 350, 150, 25);
        add(lblnumber);

        labelnumber = new JLabel();
        labelnumber.setBounds(250, 350, 150, 25);
        add(labelnumber);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(40, 390, 150, 25);
        add(lblphone);

        labelphone = new JLabel();
        labelphone.setBounds(250, 390, 150, 25);
        add(labelphone);

        JLabel lbltotalprice = new JLabel("Total Price");
        lbltotalprice.setBounds(40, 430, 150, 25);
        add(lbltotalprice);

        labeltotal = new JLabel();
        labeltotal.setBounds(250, 430, 150, 25);
        add(labeltotal);

        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM customer WHERE Username = '" + username + "'";
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
        checkprice.setBounds(60, 490, 120, 25);
        checkprice.addActionListener(this);
        add(checkprice);

        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200, 490, 120, 25);
        bookpackage.addActionListener(this);
        add(bookpackage);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340, 490, 120, 25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 500, 300);
        add(image);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == checkprice) {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select *from hotel where name = '" + chotel.getSelectedItem() + "'");
          while(rs.next()){
              int cost = Integer.parseInt(rs.getString("costperperson"));
              int food = Integer.parseInt(rs.getString("food"));
              int ac = Integer.parseInt(rs.getString("acroom"));


              int person = Integer.parseInt(tfperson.getText());
              int days = Integer.parseInt(tfdays.getText());

              String acselected = ctype.getSelectedItem();
              String foodselected = cfood.getSelectedItem();

              if(person * days > 0){
                  int total = 0;
                  total += acselected.equals("AC") ? ac:0;
                  total +=foodselected.equals("YES") ? food : 0 ;
                  total +=cost;
                  total = total * person * days;
                  labeltotal.setText("Rs "+total);



              }else {
                  JOptionPane.showMessageDialog(null, "please enter a valid number");
              }
          }

            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource() == bookpackage) {
            try {
                Conn c = new Conn();
                String query = "INSERT INTO hotelbook VALUES('"
                        + labelusername.getText() + "','"
                        + chotel.getSelectedItem() + "','"
                        + tfperson.getText() + "','"
                        + tfdays.getText() + "','"
                        +ctype.getSelectedItem() + "','"
                        +cfood.getSelectedItem() + "','"

                        + labelid.getText() + "','"
                        + labelnumber.getText() + "','"
                        + labelphone.getText() + "','"
                        + labeltotal.getText() + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Hotel Booked Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookHotel("tanish90");
    }
}
