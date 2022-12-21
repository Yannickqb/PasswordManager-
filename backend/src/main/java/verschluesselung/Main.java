package verschluesselung;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Encryption test = new Encryption();
        DB db = new DB();
        User user1 = new User("yannick", "testdsfjaöfniuwefkjblblibibböwbfüäow");
        User user2 = new User("Emil", "Gaylord");
        String encrypted = test.encrypt("passwort", user1);
        UserPassword userPassword = new UserPassword("nema", "12eef", "https://google.com");
        user1.addUserPassword(userPassword);

        String encrypted2 = test.encrypt("password", user2);
        db.addUser(user1);
        UserPassword userPassword2 = new UserPassword("aa", "123456", "https://jsö.com");
        user1.addUserPassword(userPassword);
        System.out.println (userPassword.getPasswordSite());
        db.safe(user1);
        db.load();
        System.out.println(encrypted);
        System.out.println(encrypted2);
        System.out.print(test.decryption(encrypted, user1));
    }
}
