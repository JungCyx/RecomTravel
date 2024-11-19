package View;

import Main.Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JPanel {
    private final UserController controller = new UserController();

    public LoginGUI() {

        // Title label
        JLabel titleLabel = new JLabel("Welcome to TrenBudget", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

        // Panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();

        // Username
        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField(15);

        // Password
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField(15);

        // Login and register button
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        // Action Listener login button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText(); // get the username
                String password = new String(passField.getPassword()); // get the password

                // authenticate the user's info
                if (controller.authenticateInput(username, password)) {
                    // Redirect the user to the Dashboard page if authenticated
                    Mainframe.cardLayout.show(Mainframe.mainPanel, "Dashboard");
                } else {
                    // error message if the user inputs wrong credentials
                    JOptionPane.showMessageDialog(null, "Incorrect credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action listener for register button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Redirect the user to Register page
                Mainframe.cardLayout.show(Mainframe.mainPanel, "Register");
            }
        });

        // was expanding the text fields so had to control the size
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Username label
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(userLabel, gbc);

        // Username field
        gbc.gridx = 1;
        formPanel.add(userField, gbc);

        // Password label
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(passLabel, gbc);

        // Password field
        gbc.gridx = 1;
        formPanel.add(passField, gbc);

        // Login button (centered)
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginButton, gbc);

        // Register button (left-aligned)
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        formPanel.add(registerButton, gbc);

        // Add form panel to the center
        add(formPanel, BorderLayout.CENTER);

        // Logo on the left side
        JLabel logoLabel = new JLabel();
        ImageIcon logoIcon = new ImageIcon("Images/trenimage.png");
        logoLabel.setIcon(logoIcon);
        logoLabel.setPreferredSize(new Dimension(1000, 1000));

        // Add the logo to the left side
        add(logoLabel, BorderLayout.WEST);
    }
}