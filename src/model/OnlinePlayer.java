package model;

/**
 * Created by Shahidul on 5/4/2016.
 */
public class OnlinePlayer {
    private String username;
    private String password;
    private String email;
    private int Score;

    public OnlinePlayer(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public OnlinePlayer( String username,int score) {
        Score = score;
        this.username = username;
     }

    public OnlinePlayer(String username, String password) {
        this.username = username;
        this.password = password;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
