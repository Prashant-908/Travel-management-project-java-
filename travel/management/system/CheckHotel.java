package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckHotel extends JFrame implements ActionListener {
    JLabel label;         // For the image
    JLabel hotelName;     // For the hotel name
    JButton nextButton;
    ImageIcon[] images = new ImageIcon[10];
    String[] names = {
            "JM Marriott Hotel", "Four Seasons Hotel", "Raddisson Blu Hotel", "Classio Hotel",
            "The Bay Club Hotel", "Breeze Blow Hotel", "Happy Mortel", "Sunrise Hotel",
            "River View Hotel", "Beach Hotel"
    };

    int count = 0;

    CheckHotel() {
        setBounds(250, 60, 800, 600);
        setLayout(null);

        // Load and scale images
        for (int i = 0; i < 10; i++) {
            ImageIcon rawIcon = new ImageIcon(ClassLoader.getSystemResource("icons/hotel" + (i + 1) + ".jpg"));
            Image img = rawIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(img);
        }

        // Display first image
        label = new JLabel(images[0]);
        label.setBounds(0, 0, 800, 500);
        add(label);

        // Hotel name label
        hotelName = new JLabel(names[0], SwingConstants.CENTER);
        hotelName.setFont(new Font("Tahoma", Font.BOLD, 20));
        hotelName.setBounds(0, 510, 800, 30);
        add(hotelName);

        // Next button
        nextButton = new JButton("Next");
        nextButton.setBounds(680, 530, 80, 20);
        nextButton.addActionListener(this);
        add(nextButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count = (count + 1) % images.length;
        label.setIcon(images[count]);
        hotelName.setText(names[count]);
    }

    public static void main(String[] args) {
        new CheckHotel();
    }
}
