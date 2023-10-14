import java.util.Scanner;

public class Main {

    public static Scanner scan = new Scanner(System.in);

    public static String text;
    public static StringBuilder alphabeth = new StringBuilder();

    public static void start(){
        System.out.println("1)Encryption\n2)Decrytion\n3)Brute Force\n4)Exit");
    }

//encryption function...
    public static String encryption(){

        int k;
        int i;

        for(char c = 'a';c < 'z'; c++){
            alphabeth.append(c);
        }

        String alpha = alphabeth.toString();


        System.out.println("Insert the text for encyption");

        text = scan.nextLine();

        System.out.println("Insert the key for the encryption");

        k = scan.nextInt();

        if (k >= 1 && k <= 25) {
            StringBuilder encryptedText = new StringBuilder();
            for (i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                if (currentChar >= 'a' && currentChar <= 'z') {
                    int index = (alpha.indexOf(currentChar) + k) % 26;
                    encryptedText.append(alpha.charAt(index));
                } else {
                    encryptedText.append(currentChar);
                }
            }
            System.out.println(encryptedText);
            return encryptedText.toString();
        } else {
            return "Invalid key. Please use a key between 1 and 25.";
        }
    }
//decryption function...
    public static String decryption() {
        int k;
        int i;

        System.out.println("Insert the text for decryption:");
        String text = scan.nextLine();

        for (char c = 'a'; c <= 'z'; c++) {
            alphabeth.append(c);
        }

        String alpha = alphabeth.toString();

        System.out.println("Insert the k for decryption");
        k = scan.nextInt();

        if (k >= 1 && k <= 25) {
            StringBuilder decryptedText = new StringBuilder();
            for (i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                if (currentChar >= 'a' && currentChar <= 'z') {
                    int index = (alpha.indexOf(currentChar) - k + 26) % 26;
                    decryptedText.append(alpha.charAt(index));
                } else {
                    decryptedText.append(currentChar);
                }
            }
            System.out.println(decryptedText);
            return decryptedText.toString();
        } else {
            return "Invalid key. Please use a key between 1 and 25.";
        }
    }

//Brute force for caesar encryption...
    public static String caesarBrute(String text ,int k){

        int i;

        for (char c = 'a'; c <= 'z'; c++) {
            alphabeth.append(c);
        }

        String alpha = alphabeth.toString();


        if (k >= 1 && k <= 25) {
            StringBuilder decryptedText = new StringBuilder();
            for (i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);
                if (currentChar >= 'a' && currentChar <= 'z') {
                    int index = (alpha.indexOf(currentChar) - k + 26) % 26;
                    decryptedText.append(alpha.charAt(index));
                } else {
                    decryptedText.append(currentChar);
                }
            }
            System.out.println(decryptedText + " Key: " + k);
            return decryptedText.toString();
        } else {
            return "Invalid key. Please use a key between 1 and 25.";
        }
    }


    public static void main(String[] args){

        while (true){
            start();
            int switcher;
            switcher = scan.nextInt();
            scan.nextLine();
            switch (switcher){
                case 1:encryption(); break;
                case 2:decryption();break;
                case 3:
                    System.out.println("Insert the text for brute force: ");
                    String textForBrute = scan.nextLine();
                    for(int i = 1; i<26; i++ ){
                        caesarBrute(textForBrute,i);
                    }

                    break;
                case 4:System.exit(0);break;
                    default:System.out.println("Wrong Choice");break;
            }
        }

    }
}
