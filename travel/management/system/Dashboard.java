package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Dashboard extends JFrame  implements ActionListener {
    String username;
    JButton addpersonalDetail,viewPersonalDetails,updatePersonalDetails,checkpackage,bookpackage,viewhotel,destination,bookhotel;
    Dashboard(String username){
        this.username = username;
        //  setBounds(0,0,1400,900);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);


        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0,0,102));
        p1.setBounds(0,0,1500,65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 =i1.getImage().getScaledInstance(70,70, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0,70,70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0,0,102));
        p2.setBounds(0,65,250,900);
        add(p2);

        addpersonalDetail= new JButton("AddPersonalDetails");
        addpersonalDetail.setBounds(0,0,250,50);
        addpersonalDetail.setBackground(new Color(0,0,102));
        addpersonalDetail.setForeground(Color.WHITE);
        addpersonalDetail.setFont(new Font("Tahoma",Font.PLAIN,20));
        addpersonalDetail.addActionListener(this);
        setLayout(null);
        p2.add(addpersonalDetail);



       updatePersonalDetails = new JButton("UpdatePersonalDetails");
        updatePersonalDetails.setBounds(0,50,280,50);
        updatePersonalDetails.setBackground(new Color(0,0,102));
        updatePersonalDetails.setForeground(Color.WHITE);
        updatePersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updatePersonalDetails.setMargin(new Insets(0,0,0,30));
        updatePersonalDetails.addActionListener(this);
        setLayout(null);
        p2.add(updatePersonalDetails);






      viewPersonalDetails = new JButton("ViewPersonalDetails");
        viewPersonalDetails.setBounds(0,100,280,50);
        viewPersonalDetails.setBackground(new Color(0,0,102));
        viewPersonalDetails.setForeground(Color.WHITE);
        viewPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPersonalDetails.setMargin(new Insets(0,0,0,50));
        viewPersonalDetails.addActionListener(this);
        setLayout(null);
        p2.add(viewPersonalDetails);



        JButton deletPersonalDetails = new JButton("DeletPersonalDetails");
        deletPersonalDetails.setBounds(0,150,280,50);
        deletPersonalDetails.setBackground(new Color(0,0,102));
        deletPersonalDetails.setForeground(Color.WHITE);
        deletPersonalDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deletPersonalDetails.setMargin(new Insets(0,0,0,70));
        setLayout(null);
        p2.add(deletPersonalDetails);

        checkpackage = new JButton("Check Package ");
        checkpackage.setBounds(0,200,280,50);
        checkpackage .setBackground(new Color(0,0,102));
        checkpackage .setForeground(Color.WHITE);
        checkpackage .setFont(new Font("Tahoma",Font.PLAIN,20));
        checkpackage .setMargin(new Insets(0,0,0,90));
        checkpackage.addActionListener(this);
        setLayout(null);
        p2.add(checkpackage) ;


       bookpackage = new JButton("Book Package ");
        bookpackage.setBounds(0,250,280,50);
        bookpackage.setBackground(new Color(0,0,102));
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookpackage.setMargin(new Insets(0,0,0,110));
        bookpackage.addActionListener(this);

        setLayout(null);
        p2.add( bookpackage) ;


        JButton viewpackage = new JButton("View Package ");
        viewpackage .setBounds(0,300,280,50);
        viewpackage .setBackground(new Color(0,0,102));
        viewpackage .setForeground(Color.WHITE);
        viewpackage .setFont(new Font("Tahoma",Font.PLAIN,20));
        viewpackage .setMargin(new Insets(0,0,0,110));
        setLayout(null);
        p2.add(viewpackage ) ;

        viewhotel = new JButton("View Hotel ");
        viewhotel.setBounds(0,350,280,50);
        viewhotel.setBackground(new Color(0,0,102));
        viewhotel.setForeground(Color.WHITE);
        viewhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewhotel.setMargin(new Insets(0,0,0,110));
        viewhotel.addActionListener(this);
        setLayout(null);
        p2.add(viewhotel) ;



        bookhotel = new JButton("Book Hotel ");
        bookhotel.setBounds(0,400,280,50);
        bookhotel.setBackground(new Color(0,0,102));
        bookhotel.setForeground(Color.WHITE);
        bookhotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookhotel.setMargin(new Insets(0,0,0,110));
        bookhotel.addActionListener(this);
        setLayout(null);
        p2.add(bookhotel) ;


        destination = new JButton("Destinations");
        destination.setBounds(0,450,280,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,110));
        destination.addActionListener(this);
        setLayout(null);
        p2.add(destination) ;


        JButton about = new JButton("About");
        about .setBounds(0,500,280,50);
        about .setBackground(new Color(0,0,102));
        about .setForeground(Color.WHITE);
        about .setFont(new Font("Tahoma",Font.PLAIN,20));
        about .setMargin(new Insets(0,0,0,110));
        setLayout(null);
        p2.add(about ) ;


        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 =new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);



        JLabel text= new JLabel("GoFly: Fly To New Place");
        text.setBounds(350, 70,1200,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.PLAIN,55));

        image.add(text);











        setVisible(true);
    }

    public  void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == addpersonalDetail) {
            new AddCustomer("paras");
        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer("paras");
        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);
        } else if (ae.getSource() == checkpackage) {
            new CheckPackage();
        } else if (ae.getSource() == bookpackage) {
            new BookPackage("paras");

        } else if (ae.getSource() == viewhotel) {
            new CheckHotel();

        }else if(ae.getSource()== destination){
            new Destination();
        }else if(ae.getSource()== bookhotel){
            new BookHotel("paras");
        }


    }

    public static  void main (String[] args){
        new Dashboard("  ");
    }
}