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
        frame.setSize(600, 400);
        frame.setLayout(new GridLayout(2, 1));

        JPanel encryptPanel = new JPanel(new GridLayout(5, 2));
        JPanel decryptPanel = new JPanel(new GridLayout(5, 2));

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

        encryptPanel.add(messageLabel);
        encryptPanel.add(messageField);
        encryptPanel.add(firstKeyLabel);
        encryptPanel.add(firstKeyField);
        encryptPanel.add(encryptedMessageLabel);
        encryptPanel.add(encryptedMessageField);
        encryptPanel.add(keyLabel);
        encryptPanel.add(keyField);
        encryptPanel.add(new JLabel()); // Empty label for spacing
        encryptPanel.add(encryptButton);

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

        decryptPanel.add(encryptedMessageLabelD);
        decryptPanel.add(encryptedMessageFieldD);
        decryptPanel.add(firstKeyLabelD);
        decryptPanel.add(firstKeyFieldD);
        decryptPanel.add(keyLabelD);
        decryptPanel.add(keyFieldD);
        decryptPanel.add(decryptedMessageLabel);
        decryptPanel.add(decryptedMessageField);
        decryptPanel.add(new JLabel()); // Empty label for spacing
        decryptPanel.add(decryptButton);

        frame.add(encryptPanel);
        frame.add(decryptPanel);

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
