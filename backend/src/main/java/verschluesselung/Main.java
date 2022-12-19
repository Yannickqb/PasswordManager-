package verschluesselung;

import verschluesselung.Encryption;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Encryption test = new Encryption();
        DB db = new DB();
        User user1 = new User("yannick", "testdsfjaöfniuwefkjblblibibböwbfüäow");
        String encrypted = test.encrypt("passwort", user1);
        UserPassword userPassword = new UserPassword("nema", "123456", "https://google.com");
        user1.addUserPassword(userPassword);
        db.addUser(user1);
        UserPassword userPassword1 = new UserPassword("aa", "123456", "https://jsö.com");
        user1.addUserPassword(userPassword1);
        db.safe();
        db.load();
        System.out.println(encrypted);
        System.out.print(test.decryption(encrypted, user1));
    }
}
