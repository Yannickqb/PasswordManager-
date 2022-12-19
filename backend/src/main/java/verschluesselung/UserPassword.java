package verschluesselung;

public class UserPassword {
    private String usernameSite;
    private String passwordSite;
    private String link;

    public UserPassword(String usernameSite, String passwordSite, String link) {
        this.usernameSite = usernameSite;
        this.passwordSite = passwordSite;
        this.link = link;
    }

    public String getUsernameSite() {
        return usernameSite;
    }

    public String getPasswordSite() {
        return passwordSite;
    }

    public String getLink() {
        return link;
    }

}
