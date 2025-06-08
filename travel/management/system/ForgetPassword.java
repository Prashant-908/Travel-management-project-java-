package travel.management.system;
import javax.swing.*;
import java.awt.*;


public class ForgetPassword extends JFrame {
   JTextField tfusername, tfname;
   JButton search;





    ForgetPassword(){
        setBounds(300,200,850,380);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel Image = new JLabel(i3);
        Image.setBounds(580, 70, 200, 200 );
        add(Image);


        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30, 30, 500, 280);
        add(p1);

        JLabel l1 = new JLabel("Username");
        l1.setBounds(40,20,100,25);
        l1.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l1);

        tfusername =new JTextField();
        tfusername.setBounds(160, 20, 150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        search = new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(350, 20,100,25);
        p1.add(search);

        JLabel l2 = new JLabel("Name");
        l2.setBounds(40,60,100,25);
        l2.setFont(new Font("Tahoma",Font.BOLD, 14));
        p1.add(l2);

        tfname =new JTextField();
        tfname.setBounds(160, 60, 150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        







    }

    public static void main(String[] args){
        new ForgetPassword();

    }


}
