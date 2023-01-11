package verschluesselung;

import java.util.ArrayList;

public class User {
    public static String password;
    protected int userid;
    protected String username = "Gast";
    protected static int number = 0;
    public String pa;


    private ArrayList<UserPassword> usersPasswords = new ArrayList<>();


    public User() {
        userid = number++;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.userid = number++;
    }

    protected String getUsername() {
        return username;
    }

    protected String getPassword() {
        return password;
    }

    public ArrayList<UserPassword> getUserPasswordsList() {
        return usersPasswords;
    }

    public UserPassword getSpecificPassword(String link){
        for (UserPassword userPassword : usersPasswords
             ) {
            if (userPassword.getLink().equals(link)){
                return userPassword;
            }
        }
        return null;
    }

    public void addUserPassword(UserPassword userPassword){
        usersPasswords.add(userPassword);
    }
}
