package LoginPage;

import jnafilechooser.api.JnaFileChooser;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.Files;

public class MainAppPage extends JFrame implements ActionListener {

    JButton createDatabaseButton = new JButton("Create Database");
    JButton sendFileButton = new JButton("Send File");

    //String desktopPath = desktop.getAbsolutePath();
    String testPath = "C:\\Users\\oscar\\OneDrive\\Dokumenty\\Test";
    String folderName = "DatabaseFolder";
    File newFolder = new File(testPath, folderName);

    MainAppPage() {
        createDatabaseButton.setBounds(30, 30, 150, 30);
        createDatabaseButton.setFocusable(false);
        createDatabaseButton.addActionListener(this);

        sendFileButton.setBounds(30, 80, 150, 30);
        sendFileButton.setFocusable(false);
        sendFileButton.addActionListener(this);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900, 700);
        this.setVisible(false);

        this.add(createDatabaseButton);
        this.add(sendFileButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createDatabaseButton) {
            if (!newFolder.exists()) {
                boolean created = newFolder.mkdir();
                if (created) {
                    System.out.println("Folder created");
                    JOptionPane.showMessageDialog(this, "Folder created, Path: " + newFolder.getAbsolutePath());
                } else {
                    System.out.println("Folder failed to create");
                }
            } else {
                System.out.println("Folder already exists");
                JOptionPane.showMessageDialog(this, "Folder already exists");
            }

            System.out.println("Checking path: " + newFolder.getAbsolutePath());
        }

        if (e.getSource() == sendFileButton) {
            JnaFileChooser jnaFileChooser = new JnaFileChooser();
            jnaFileChooser.setMode(JnaFileChooser.Mode.Files);
            jnaFileChooser.addFilter("Text Files", "txt");

            if (jnaFileChooser.showOpenDialog(this)) {
                File selectedFile = jnaFileChooser.getSelectedFile();
                Path sourcePath = selectedFile.toPath();
                    Path destinationPath = Path.of(testPath + "//" + folderName, selectedFile.getName());

                try {
                    Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(this, "File sent to: " + destinationPath);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
                }
            }
        }
    }
}
