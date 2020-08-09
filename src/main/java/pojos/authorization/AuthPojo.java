package pojos.authorization;

public class AuthPojo {

    String username;
    String password;

    public AuthPojo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public AuthPojo setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthPojo setPassword(String password) {
        this.password = password;
        return this;
    }
}
