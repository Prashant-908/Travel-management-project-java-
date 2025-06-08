package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Destination extends JFrame implements ActionListener {
    JLabel label;         // For the image
    JLabel destinationName;
    JButton nextButton;
    ImageIcon[] images = new ImageIcon[9];  // For 9 destinations
    String[] names = {
            "Mussoorie, Uttarakhand",
            "Pithoragarh, Uttarakhand",
            "Leh-Ladakh, Jammu & Kashmir",
            "Rishikesh, Uttarakhand",
            "Ooty, Tamil Nadu",
            "Mysore, Karnataka",
            "Jaipur, Rajasthan",
            "India Gate, New Delhi",
            "Shimla, Himachal Pradesh"
    };

    int count = 0;

    Destination() {
        setBounds(250, 60, 800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setTitle("Indian Destinations");

        // Load and scale images
        for (int i = 0; i < images.length; i++) {
            try {
                ImageIcon rawIcon = new ImageIcon(ClassLoader.getSystemResource("icons/dest" + (i + 1) + ".jpg"));
                if (rawIcon != null) {
                    Image img = rawIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
                    images[i] = new ImageIcon(img);
                } else {
                    System.err.println("Could not load image: icons/dest" + (i + 1) + ".jpg");
                    // Create a blank image as fallback
                    BufferedImage blankImage = new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
                    images[i] = new ImageIcon(blankImage);
                }
            } catch (Exception e) {
                System.err.println("Error loading image: " + e.getMessage());
                BufferedImage blankImage = new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
                images[i] = new ImageIcon(blankImage);
            }
        }

        // Display first image
        label = new JLabel(images[0]);
        label.setBounds(0, 0, 800, 500);
        add(label);

        // Destination name label with improved styling
        destinationName = new JLabel(names[0], SwingConstants.CENTER);
        destinationName.setFont(new Font("Tahoma", Font.BOLD, 22));
        destinationName.setForeground(new Color(0, 100, 0));  // Dark green color
        destinationName.setBounds(0, 510, 800, 30);
        add(destinationName);

        // Next button with better styling
        nextButton = new JButton("Next Destination");
        nextButton.setBounds(650, 530, 130, 30);
        nextButton.setBackground(new Color(0, 120, 215));
        nextButton.setForeground(Color.WHITE);
        nextButton.addActionListener(this);
        add(nextButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        count = (count + 1) % images.length;
        label.setIcon(images[count]);
        destinationName.setText(names[count]);
    }

    public static void main(String[] args) {
        new Destination();
    }
}