package LoginPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class RegisterPage implements ActionListener {
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    IdAndPass idAndPassword;
    LoginPage loginPage;

    JFrame frame = new JFrame();
    JButton RegisterButton = new JButton("Create");
    JButton resetButton = new JButton("Reset");
    JButton loginButton = new JButton("Already have account");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User Id:");
    JLabel userPasswordLabel = new JLabel("User Password:");
    JLabel messageLabel = new JLabel();

    RegisterPage(IdAndPass sharedIdAndPass) {
        this.idAndPassword = sharedIdAndPass;
        this.loginPage = new LoginPage(sharedIdAndPass);

        loginInfo = sharedIdAndPass.getLoginInfo();

        userIdLabel.setBounds(50, 100, 75, 25);
        userIdField.setBounds(150, 100, 120, 25);

        userPasswordLabel.setBounds(50, 150, 75, 25);
        userPasswordField.setBounds(150, 150, 120, 25);

        messageLabel.setBounds(125, 250, 550, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        RegisterButton.setBounds(50, 200, 100, 25);
        RegisterButton.addActionListener(this);
        RegisterButton.setFocusable(false);
        RegisterButton.setFont(new Font("Comic Sans", Font.BOLD, 14));
        RegisterButton.setForeground(Color.WHITE);
        RegisterButton.setBackground(Color.BLUE);

        resetButton.setBounds(170, 200, 100, 25);
        resetButton.addActionListener(this);
        resetButton.setFocusable(false);
        resetButton.setForeground(Color.WHITE);
        resetButton.setFont(new Font("Comic Sans", Font.BOLD, 14));
        resetButton.setBackground(Color.RED);

        loginButton.setBounds(290, 200, 170, 25);
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);

        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(RegisterButton);
        frame.add(messageLabel);
        frame.add(resetButton);
        frame.add(loginButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(null);
    }

    public void actionPerformed(ActionEvent e) {
        String userID = userIdField.getText();
        String userPassword = new String(userPasswordField.getPassword());

        if (e.getSource() == resetButton) {
            userIdField.setText("");
            userPasswordField.setText("");
        }
        if (e.getSource() == RegisterButton) {
            if (!userID.matches("^[a-zA-Z0-9]+$") || userID.contains(" ")) {
                JOptionPane.showMessageDialog(frame, "Please enter user ID correctly.");
            } else if (!userPassword.matches("^[a-zA-Z0-9]+$") || userPassword.contains(" ")) {
                JOptionPane.showMessageDialog(frame, "Please enter user Password correctly.");
            } else {
                if (loginInfo.containsKey(userID)) {
                    JOptionPane.showMessageDialog(frame, "User already exists.");
                } else {
                    idAndPassword.createUser(userID, userPassword);
                    System.out.println("All Logins: " + idAndPassword.getLoginInfo());
                    System.out.println(userID + " has created his account");
                    messageLabel.setText("Login Successful, Welcome " + userID);
                }
            }
        }
        if (e.getSource() == loginButton) {
            loginPage.setVisible(true);
            frame.setVisible(false);
        }
    }

}
