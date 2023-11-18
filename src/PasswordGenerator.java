import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

public class PasswordGenerator extends JFrame {

    private JTextField passwordField;

    public PasswordGenerator() {
        setTitle("Password generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel.setBackground(Color.decode("#3498db")); 
        JLabel titleLabel = new JLabel("Password generator");
        titleLabel.setForeground(Color.WHITE); 
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        topPanel.add(titleLabel);

        JPanel centerPanel = new JPanel(new FlowLayout());
        centerPanel.setBackground(Color.WHITE); 
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); 

        JLabel passwordLabel = new JLabel("Password generation:");
        passwordField = new JTextField(20);
        passwordField.setEditable(false);

        JButton generateButton = new JButton("Generate password");
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = generatePassword();
                passwordField.setText(password);
            }
        });

        centerPanel.add(passwordLabel);
        centerPanel.add(passwordField);
        centerPanel.add(generateButton);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(Color.decode("#2ecc71")); 
        JLabel footerLabel = new JLabel("© 2023 - C4rb0");
        footerLabel.setForeground(Color.WHITE); 
        bottomPanel.add(footerLabel);

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private String generatePassword() {
        String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String allCharacters = uppercaseLetters + lowercaseLetters + numbers + specialCharacters;
        SecureRandom random = new SecureRandom();

        StringBuilder password = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int randomIndex = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(randomIndex));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordGenerator();
            }
        });
    }
}