import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Project: Fun Substitution Cipher
 * Purpose Details: A fun substitution cipher that encrypts and decrypts messages using a predefined mapping.
 * Course: IST 242
 * Author: Aayudh Nandiwdekar
 * Date Developed: 10/28/2024
 * Last Date Changed: 10/28/2024
 * Revision: 2
 */
public class FunSubstitutionCipher {
    private static Map<Character, Character> cipherMap = new HashMap<>();
    private static Map<Character, Character> reverseCipherMap = new HashMap<>();

    static {
        // Mapping of letters (uppercase and lowercase)
        cipherMap.put('A', '1');
        cipherMap.put('a', '1');
        cipherMap.put('B', '2');
        cipherMap.put('b', '2');
        cipherMap.put('C', '3');
        cipherMap.put('c', '3');
        cipherMap.put('D', '4');
        cipherMap.put('d', '4');
        cipherMap.put('E', '5');
        cipherMap.put('e', '5');
        cipherMap.put('F', '6');
        cipherMap.put('f', '6');
        cipherMap.put('G', '7');
        cipherMap.put('g', '7');
        cipherMap.put('H', '8');
        cipherMap.put('h', '8');
        cipherMap.put('I', '9');
        cipherMap.put('i', '9');
        cipherMap.put('J', '!');
        cipherMap.put('j', '!');
        cipherMap.put('K', '@');
        cipherMap.put('k', '@');
        cipherMap.put('L', '#');
        cipherMap.put('l', '#');
        cipherMap.put('M', '$');
        cipherMap.put('m', '$');
        cipherMap.put('N', '%');
        cipherMap.put('n', '%');
        cipherMap.put('O', '^');
        cipherMap.put('o', '^');
        cipherMap.put('P', '&');
        cipherMap.put('p', '&');
        cipherMap.put('Q', '*');
        cipherMap.put('q', '*');
        cipherMap.put('R', '(');
        cipherMap.put('r', '(');
        cipherMap.put('S', ')');
        cipherMap.put('s', ')');
        cipherMap.put('T', '-');
        cipherMap.put('t', '-');
        cipherMap.put('U', '+');
        cipherMap.put('u', '+');
        cipherMap.put('V', '=');
        cipherMap.put('v', '=');
        cipherMap.put('W', '{');
        cipherMap.put('w', '{');
        cipherMap.put('X', '}');
        cipherMap.put('x', '}');
        cipherMap.put('Y', '[');
        cipherMap.put('y', '[');
        cipherMap.put('Z', ']');
        cipherMap.put('z', ']');

        // Create reverse mapping for decryption
        for (Map.Entry<Character, Character> entry : cipherMap.entrySet()) {
            reverseCipherMap.put(entry.getValue(), entry.getKey());
        }
    }

    // Method to encrypt the message, preserving case information
    public static String encrypt(String message) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (cipherMap.containsKey(ch)) {
                encryptedMessage.append(cipherMap.get(ch)); // Append corresponding character
            } else if (Character.isWhitespace(ch)) {
                encryptedMessage.append(" "); // Preserve spaces
            } else {
                encryptedMessage.append(ch); // Non-alphabet characters remain unchanged
            }
        }
        return encryptedMessage.toString();
    }

    // Method to decrypt the message, preserving original case
    public static String decrypt(String message, String originalCase) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (reverseCipherMap.containsKey(ch)) {
                char originalChar = reverseCipherMap.get(ch);
                // Apply original case based on input
                decryptedMessage.append(Character.isUpperCase(originalCase.charAt(i))
                        ? Character.toUpperCase(originalChar)
                        : Character.toLowerCase(originalChar));
            } else if (Character.isWhitespace(ch)) {
                decryptedMessage.append(" "); // Preserve spaces
            } else {
                decryptedMessage.append(ch); // Non-alphabet characters remain unchanged
            }
        }
        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the message to encrypt
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();

        // Encrypt the message
        String encryptedMessage = encrypt(message);
        System.out.println("Encrypted Message: " + encryptedMessage);

        // Ask for decryption
        System.out.print("Enter the message to decrypt: ");
        String encryptedInput = scanner.nextLine(); // Get the input for decryption

        // Decrypt the message, using original input for case preservation
        String decryptedMessage = decrypt(encryptedInput, message);
        System.out.println("Decrypted Message: " + decryptedMessage);

        scanner.close(); // Close the scanner
    }
}
