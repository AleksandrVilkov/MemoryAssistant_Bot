package bot;

public class BotAuthorization {
    private String token;
    private String username;

    public BotAuthorization() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
