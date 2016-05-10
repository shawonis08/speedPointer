package service;

import data.DataBaseConnection;
import model.OnlinePlayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

/**
 * Created by Shahidul on 5/4/2016.
 */
public class DataBaseService {

    private DataBaseConnection dataBaseConnection = new DataBaseConnection();
    private OnlinePlayer newplayer, logplayer;
    private int isUserinserted;


    public boolean playerRegistration(String uname, String email, String pass) {
        newplayer = new OnlinePlayer(email, pass, uname);
        String insert = "INSERT INTO registrations VALUES('" + newplayer.getUsername() + "'," + "'" + newplayer.getEmail() + "'," + "'" + newplayer.getPassword() + "'," + 0 + "," + 1 + ");";
        System.out.println(insert);
        int a = 0;
        try {
            a = dataBaseConnection.inupdatedel(insert);
        } catch (NullPointerException e){
            System.out.println("Error");
        }
        if (a == 1) {
            return true;
        }
        else {
            return false;
        }

    }

    public boolean playerLogin(String u, String p) {
        logplayer = new OnlinePlayer(u, p);
        String query = "SELECT auth FROM registrations WHERE uname='" + logplayer.getUsername() + "' And  password='" + logplayer.getPassword() + "';";
        System.out.println(query);
        try {
            ResultSet rs = dataBaseConnection.selectQuery(query);
            if (rs.next()) {
                int a = rs.getInt("auth");
                if (a == 1)
                    return true;
                else
                    return false;
            }
        } catch (SQLException e) {
                System.out.println("Error authentication");
        }
        return false;
    }

    public ArrayList<OnlinePlayer> playerScore() {
        String query="SELECT uname,hscore FROM `registrations` ORDER By hscore DESC";
        System.out.println(query);

        ArrayList<OnlinePlayer> scoreList = new ArrayList<>();
        try {
            ResultSet rs = dataBaseConnection.selectQuery(query);
            while (rs.next()) {

                scoreList.add(new OnlinePlayer(rs.getString("uname").toUpperCase(),rs.getInt("hscore") ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scoreList;
    }

    public int updatescore(String userName,int score) {
        String query = "UPDATE registrations Set hscore="+score+" WHERE uname='"+userName+"';";
        System.out.println(query);


            return isUserinserted = dataBaseConnection.inupdatedel(query);

    }

    public boolean getIsUserinserted() {
        if (isUserinserted == 1)
            return true;
        else
            return false;
    }

}
