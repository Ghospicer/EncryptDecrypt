import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncryptDecryptGUI {
    private static final String SECTION1 = "ÜÖŞÇĞİüöşçğı ";
    private static final String SECTION2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String SECTION3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String SECTION4 = "0123456789";

    public static List<Character> createKeyFromFirstKey(String firstKey) {
        String[] sections = {SECTION1, SECTION2, SECTION3, SECTION4};
        List<Character> newChars = new ArrayList<>();
        for (char num : firstKey.toCharArray()) {
            String section = sections[Character.getNumericValue(num) - 1];
            for (char c : section.toCharArray()) {
                newChars.add(c);
            }
        }
        return newChars;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Encrypt/Decrypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new GridBagLayout());

        JPanel encryptPanel = new JPanel(new GridBagLayout());
        JPanel decryptPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0.5;
        gbc.weighty = 1.0;

        // Encryption panel components
        JLabel messageLabel = new JLabel("Enter message:");
        JTextField messageField = new JTextField();
        JLabel firstKeyLabel = new JLabel("Enter first key (1-4):");
        JTextField firstKeyField = new JTextField();
        JLabel encryptedMessageLabel = new JLabel("Encrypted message:");
        JTextField encryptedMessageField = new JTextField();
        encryptedMessageField.setEditable(false);
        JLabel keyLabel = new JLabel("Key:");
        JTextField keyField = new JTextField();
        keyField.setEditable(false);
        JButton encryptButton = new JButton("Encrypt");

        // Add encryption components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        encryptPanel.add(messageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        encryptPanel.add(messageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        encryptPanel.add(firstKeyLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        encryptPanel.add(firstKeyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        encryptPanel.add(encryptedMessageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        encryptPanel.add(encryptedMessageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        encryptPanel.add(keyLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        encryptPanel.add(keyField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        encryptPanel.add(encryptButton, gbc);

        // Decryption panel components
        JLabel encryptedMessageLabelD = new JLabel("Enter encrypted message:");
        JTextField encryptedMessageFieldD = new JTextField();
        JLabel firstKeyLabelD = new JLabel("Enter first key (1-4):");
        JTextField firstKeyFieldD = new JTextField();
        JLabel keyLabelD = new JLabel("Enter key:");
        JTextField keyFieldD = new JTextField();
        JLabel decryptedMessageLabel = new JLabel("Decrypted message:");
        JTextField decryptedMessageField = new JTextField();
        decryptedMessageField.setEditable(false);
        JButton decryptButton = new JButton("Decrypt");

        // Add decryption components to panel
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        decryptPanel.add(encryptedMessageLabelD, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        decryptPanel.add(encryptedMessageFieldD, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        decryptPanel.add(firstKeyLabelD, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        decryptPanel.add(firstKeyFieldD, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        decryptPanel.add(keyLabelD, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        decryptPanel.add(keyFieldD, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        decryptPanel.add(decryptedMessageLabel, gbc);
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        decryptPanel.add(decryptedMessageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 3;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        decryptPanel.add(decryptButton, gbc);

        // Add panels to frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        frame.add(encryptPanel, gbc);

        gbc.gridy = 1;
        frame.add(decryptPanel, gbc);

        // Styling
        encryptPanel.setBorder(BorderFactory.createTitledBorder("Encryption"));
        decryptPanel.setBorder(BorderFactory.createTitledBorder("Decryption"));

        Font font = new Font("SansSerif", Font.PLAIN, 14);
        for (Component comp : encryptPanel.getComponents()) {
            comp.setFont(font);
        }
        for (Component comp : decryptPanel.getComponents()) {
            comp.setFont(font);
        }

        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String omessage = messageField.getText();
                String firstKey = firstKeyField.getText();
                List<Character> chars = createKeyFromFirstKey(firstKey);
                List<Character> key = new ArrayList<>(chars);
                Collections.shuffle(key);
                StringBuilder ecmessage = new StringBuilder();
                for (char letter : omessage.toCharArray()) {
                    int index = chars.indexOf(letter);
                    ecmessage.append(key.get(index));
                }
                encryptedMessageField.setText(ecmessage.toString());
                StringBuilder dkey = new StringBuilder();
                for (char x : key) {
                    dkey.append(x);
                }
                keyField.setText(dkey.toString());
            }
        });

        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ecmessage = encryptedMessageFieldD.getText();
                String firstKey = firstKeyFieldD.getText();
                String key = keyFieldD.getText();
                List<Character> chars = createKeyFromFirstKey(firstKey);
                StringBuilder omessage = new StringBuilder();
                for (char letter : ecmessage.toCharArray()) {
                    int index = key.indexOf(letter);
                    omessage.append(chars.get(index));
                }
                decryptedMessageField.setText(omessage.toString());
            }
        });

        frame.setVisible(true);
    }
}
