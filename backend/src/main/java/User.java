public class User {
    public static String password;
    protected int userid;
    protected String username = "Gast";
    protected static int number = 0;

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
}