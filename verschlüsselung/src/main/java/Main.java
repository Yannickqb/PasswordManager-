public class Main {
    public static void main(String[] args) {
        Encryption test = new Encryption();
        String encrypted = test.encrypt("passwort");
        System.out.println(encrypted);
        System.out.print(test.decryption(encrypted));
    }
}
