package NewCode;

import javax.swing.*;
import java.awt.*;

public class GUI {
    public void mainPanel() {
        JFrame frame = new JFrame("File Organizer");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button = new JButton("Organize");
        button.setPreferredSize(new Dimension(100, 30));

        JLabel label = new JLabel("Enter Folder Path:");

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.mainPanel();
    }
}