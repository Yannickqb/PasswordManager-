package verschluesselung;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        addDummidadta();
        DB data = new DB();
        Encryption en = new Encryption();

        //load DB so you can get the data
        data.load();

        //Get the Passwords
        User yannick = data.getSpecificUser("Yannick");
        User diego = data.getSpecificUser("Diego");
        System.out.println(en.decryption(yannick.getSpecificPassword("https://google.com").getPasswordSite(), yannick));
        System.out.println(en.decryption(yannick.getSpecificPassword("https://jsö.com").getPasswordSite(), yannick));
        System.out.println(en.decryption(diego.getSpecificPassword("https://aa.com").getPasswordSite(), diego));
        System.out.println(en.decryption(diego.getSpecificPassword("https://hhh.com").getPasswordSite(), diego));






    }

    public static void addDummidadta() throws IOException {
        //Create Encryption and DB Objekt
        Encryption test = new Encryption();
        DB db = new DB();

        //Create User
        User user1 = new User("Yannick", "Yannick=GottallerGötter");
        User user2 = new User("Diego", "DiegoFuego");

        //Create encrypted Password
        String passwordsi2 = test.encrypt("110703", user1);
        String passwordsi3 = test.encrypt("AbCdEfG", user2);
        String passwordsi4 = test.encrypt("$$EE$$", user2);
        String passwordsi = test.encrypt(db.newUserPassword(), user1);
        //Create UserPassword
        UserPassword userPassworden1 = new UserPassword("nema", passwordsi, "https://google.com");
        UserPassword userPassworden2 = new UserPassword("aa", passwordsi2, "https://jsö.com");
        UserPassword userPassworden3 = new UserPassword("EmildischGay", passwordsi3, "https://aa.com");
        UserPassword userPassworden4 = new UserPassword("HH", passwordsi4, "https://hhh.com");


        //Add User to DB
        db.addUser(user1);
        db.addUser(user2);


        //Add Password to site
        user1.addUserPassword(userPassworden1);
        user1.addUserPassword(userPassworden2);
        user2.addUserPassword(userPassworden3);
        user2.addUserPassword(userPassworden4);


        //Safe data
        db.safe();




    }
}
