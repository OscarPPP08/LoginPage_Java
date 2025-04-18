package LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage extends JFrame implements ActionListener {
    HashMap<String, String> loginlist;
    IdAndPass idAndPasswords;
    MainAppPage mainAppPage;

    JButton LoginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton returnButton = new JButton("Return");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User Id:");
    JLabel userPasswordLabel = new JLabel("User Password:");

    LoginPage(IdAndPass idAndPasswords) {
        this.idAndPasswords = idAndPasswords;
        this.mainAppPage = new MainAppPage();

        loginlist = idAndPasswords.getLoginInfo();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 500);
        this.setLayout(null);
        this.setVisible(false);
        this.getContentPane().setBackground(new Color(119, 188, 255));

        userIdLabel.setBounds(50, 100, 75, 25);
        userIdField.setBounds(150, 100, 120, 25);

        userPasswordLabel.setBounds(50, 150, 75, 25);
        userPasswordField.setBounds(150, 150, 120, 25);

        LoginButton.setBounds(50, 200, 100, 25);
        LoginButton.addActionListener(this);
        LoginButton.setFocusable(false);

        resetButton.setBounds(170, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);

        returnButton.setBounds(290, 200, 100, 25);
        returnButton.addActionListener(this);
        returnButton.setFocusable(false);

        this.add(userIdLabel);
        this.add(userPasswordLabel);
        this.add(userIdField);
        this.add(userPasswordField);
        this.add(LoginButton);
        this.add(resetButton);
        this.add(returnButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LoginButton) {
            loginlist = idAndPasswords.getLoginInfo();

            String userID = userIdField.getText().trim();
            String password = String.valueOf(userPasswordField.getPassword()).trim();

            if (loginlist.containsKey(userID) && userIdField.getText() != null) {
                System.out.println("found user: " + userIdField.getText());
                if (loginlist.get(userID).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    System.out.println("Welcome: " + userIdField.getText());
                    this.setVisible(false);
                    mainAppPage.setVisible(true);
                } else {
                    System.out.println("password not found, try again");
                }

            } else {
                JOptionPane.showMessageDialog(null, "User not found, try again");
                System.out.println("user not found");
            }
        }
        if (e.getSource() == resetButton) {
            userIdField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == returnButton) {
            this.setVisible(false);
            RegisterPage registerPage = new RegisterPage(idAndPasswords);
            registerPage.frame.setVisible(true);
        }
    }
}
