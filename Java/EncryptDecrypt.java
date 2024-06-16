import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class EncryptDecrypt {
    private static final String SECTION1 = "ÜÖŞÇĞİüöşçğı ";
    private static final String SECTION2 = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
    private static final String SECTION3 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String SECTION4 = "0123456789";

    public static List<Character> createKeyFromFirstKey(String firstKey) {
        String[] sections = { SECTION1, SECTION2, SECTION3, SECTION4 };
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
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
        	System.out.print("Encrypt or Decrypt. (E/D): ");
            String choice = scanner.nextLine().trim().toUpperCase();

            if (choice.equals("E")) {
                System.out.print("Enter your message: ");
                String omessage = scanner.nextLine();
                System.out.print("Enter your first key (combination of 1-4): ");
                String firstKey = scanner.nextLine();

                // Create the new character set based on firstKey
                List<Character> chars = createKeyFromFirstKey(firstKey);

                // Generate a shuffled key
                List<Character> key = new ArrayList<>(chars);
                Collections.shuffle(key);

                // Encrypt the message
                StringBuilder ecmessage = new StringBuilder();
                for (char letter : omessage.toCharArray()) {
                    int index = chars.indexOf(letter);
                    ecmessage.append(key.get(index));
                }

                System.out.println("Encrypted message: " + ecmessage);

                // Convert key to string
                StringBuilder dkey = new StringBuilder();
                for (char x : key) {
                    dkey.append(x);
                }

                System.out.println("Key: " + dkey);
                System.out.println("First key: " + firstKey);
                System.out.print("Enter any other key than 'x' key to continue!");
                System.out.print("Enter 'x' key to exit!");
                String x=scanner.nextLine();
                if(x=="x") {
                	break;
                }

            } else if (choice.equals("D")) {
                System.out.print("Enter your message: ");
                String ecmessage = scanner.nextLine();
                System.out.print("Enter your first key (combination of 1-4): ");
                String firstKey = scanner.nextLine();
                System.out.print("Enter your key: ");
                String key = scanner.nextLine();

                // Create the new character set based on firstKey
                List<Character> chars = createKeyFromFirstKey(firstKey);

                // Decrypt the message
                StringBuilder omessage = new StringBuilder();
                for (char letter : ecmessage.toCharArray()) {
                    int index = key.indexOf(letter);
                    omessage.append(chars.get(index));
                }

                System.out.println("Original message: " + omessage);
                System.out.print("Enter any other key than 'x' key to continue!");
                System.out.print("Enter 'x' key to exit!");
                String x=scanner.nextLine();
                if(x=="x") {
                	break;
                }

            } else {
                System.out.println("Are you an idiot?");
                System.out.print("Enter any other key than 'x' key to continue!");
                System.out.print("Enter 'x' key to exit!");
                String x=scanner.nextLine();
                if(x=="x") {
                	break;
                }
            }
        }
        

        scanner.close();
    }
}
