package travel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    JTextField t1, t2, t3;  
    JButton b1, b2;
    JPasswordField t4;
    Random ran = new Random();


        Signup(){
            setBounds(350, 200, 900, 360);
            getContentPane().setBackground(Color.white);
            setLayout(null);

            JPanel p1 = new JPanel();
            p1.setBackground(new Color(133, 193, 233));
            p1.setBounds(0, 0, 500, 400);
            p1.setLayout(null);
            add(p1);
            
            

            JLabel l1 = new JLabel("Username");
            l1.setBounds(50, 20, 100, 30);  
            l1.setFont(new Font("Arial", Font.PLAIN, 20));
            p1.add(l1);


            t1 = new JTextField();
            t1.setBounds(200, 20, 150, 30); 
            t1.setFont(new Font("Arial", Font.PLAIN, 20));
            p1.add(t1);


            JLabel l2 = new JLabel("Name");     
            l2.setBounds(50, 70, 100, 30);
            l2.setFont(new Font("Arial", Font.PLAIN, 20));
            p1.add(l2);

            t2 = new JTextField();
            t2.setBounds(200, 70, 150, 30);
            t2.setFont(new Font("Arial", Font.PLAIN, 20));
            p1.add(t2);


            JLabel l3 = new JLabel("Password");
            l3.setBounds(50, 120, 100, 30);
            l3.setFont(new Font("Arial", Font.PLAIN, 20));
            p1.add(l3);

             t3 = new JPasswordField();
            t3.setBounds(200, 120, 150, 30);

            t3.setFont(new Font("Arial", Font.PLAIN, 20));
            p1.add(t3);
             

          b1 = new JButton("Create");
           b1.setBounds(50, 200, 120, 30);
           b1.setBackground(Color.white);   
              b1.setForeground(new Color(133, 193, 233));
              b1.setFont(new Font("Arial", Font.PLAIN, 20));
                b1.setBorder(BorderFactory.createEmptyBorder());   
                b1.addActionListener(this);
                p1.add(b1);
                
                
                b2 = new JButton("Back");
                b2.setBounds(200, 200, 120, 30);
                b2.setBackground(Color.white);
                b2.setForeground(new Color(133, 193, 233));
                b2.setFont(new Font("Arial", Font.PLAIN, 20));
                b2.setBorder(BorderFactory.createEmptyBorder());
                b2.addActionListener(this); 
                p1.add(b2);


                ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
                Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
                ImageIcon i3 = new ImageIcon(i2);
                JLabel l4 = new JLabel(i3);
                l4.setBounds(600, 50, 200, 200);
                add(l4);

        }


     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();

            String query= "insert into data values('"+username+"', '"+name+"', '"+password+"')";

            try{
                Conn c = new Conn();
                  c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
                e.printStackTrace();
            }
          
        }else if(ae.getSource() == b2){
            this.setVisible(false);
            new Login().setVisible(true);
       
    }
} 
    

    public static void main(String[] args){
        new Signup().setVisible(true);   
    }

}

