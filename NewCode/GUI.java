package NewCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

    private String folderPath;

    public String getFolderPath() {
        return folderPath;
    }

    public void mainPanel() {
        JFrame frame = new JFrame("File Organizer");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Enter Folder Path:");

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 30));

        JButton button = new JButton("Organize");
        button.setPreferredSize(new Dimension(100, 30));
        
        //anonymous class
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    folderPath = textField.getText();
                    Main.createSubFolder(folderPath);
                    Main.organizeFiles(folderPath);
                    History.savePath(folderPath);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        panel.add(label);
        panel.add(textField);
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}