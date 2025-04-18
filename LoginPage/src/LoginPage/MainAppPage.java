package LoginPage;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainAppPage extends JFrame implements ActionListener {

    JButton createDatabaseButton = new JButton("Create Database");

    File desktop = FileSystemView.getFileSystemView().getHomeDirectory();
    String desktopPath = desktop.getAbsolutePath();
    String folderName = "DatabaseFolder";
    File newFolder = new File(desktopPath, folderName);

    MainAppPage() {
        createDatabaseButton.setBounds(150, 150, 100, 30);
        createDatabaseButton.setFocusable(false);
        createDatabaseButton.addActionListener(this);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(900, 700);
        this.setVisible(false);

        this.add(createDatabaseButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createDatabaseButton) {
            if (!newFolder.exists()) {
                boolean created = newFolder.mkdir();
                if (created) {
                    System.out.println("Folder created");
                } else {
                    System.out.println("Folder failed to create");
                }
            } else {
                System.out.println("Folder already exists");
            }

            System.out.println("Checking path: " + newFolder.getAbsolutePath());
        }
    }
}
