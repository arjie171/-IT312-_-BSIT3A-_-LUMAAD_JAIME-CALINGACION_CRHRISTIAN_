import java.util.Scanner;

public class AutoKeyCipher {

    // SULLUTION STEPS
    public static String encrypt(String plaintext, String key) {
        plaintext = plaintext.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase();

        
        String autoKey = key + plaintext;
        autoKey = autoKey.substring(0, plaintext.length());

        String ciphertext = "";

        System.out.println("\nENCRYPTION STEPS");
        for (int i = 0; i < plaintext.length(); i++) {
            int p = plaintext.charAt(i) - 'A';   
            int k = autoKey.charAt(i) - 'A';    
            int c = (p + k) % 26;                
            char cipherChar = (char) (c + 'A');

            // PRINT THE STEPS
            System.out.println((i + 1) + ". "
                + plaintext.charAt(i) + " (" + p + ") + "
                + autoKey.charAt(i) + " (" + k + ") = "
                + c + " → " + cipherChar);

            ciphertext += cipherChar;
        }

        // PRINT THE AUTO KEY
        System.out.println("\nAuto Key: " + autoKey);

        return ciphertext;
    }

    
    public static String decrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toUpperCase().replaceAll("[^A-Z]", "");
        key = key.toUpperCase();

        String plaintext = "";
        String autoKey = key;

        System.out.println("\nDECRYPTION STEPS");
        for (int i = 0; i < ciphertext.length(); i++) {
            int c = ciphertext.charAt(i) - 'A';
            int k = autoKey.charAt(i) - 'A';
            int p = (c - k + 26) % 26;
            char plainChar = (char) (p + 'A');

            System.out.println((i + 1) + ". "
                + ciphertext.charAt(i) + " (" + c + ") - "
                + autoKey.charAt(i) + " (" + k + ") = "
                + p + " → " + plainChar);

            plaintext += plainChar;
            autoKey += plainChar; 
        }

        return plaintext;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("ENTER PLAIN_TEXT: ");
        String plaintext = sc.nextLine();

        System.out.print("ENTER KEYS: ");
        String key = sc.nextLine();

        String encrypted = encrypt(plaintext, key);
        System.out.println("CIPHERE_TEXTt: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("\nDECRYPTED: " + decrypted);

        sc.close();
    }
}