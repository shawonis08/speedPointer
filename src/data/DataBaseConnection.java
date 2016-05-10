package data;


import java.sql.*;

/**
 * Created by Shahidul on 5/4/2016.
 */
public class DataBaseConnection {
    private  String mysql = "com.mysql.cj.jdbc.Driver";
    /*private  String oracal = "oracle.jdbc.driver.OracleDriver";*/
    private  Connection connection;
    private String mysqlurl = "jdbc:mysql://localhost/speedpointer";
   /* private String Oracalurl = "jdbc:oracle:thin:@localhost:1521:xe";*/
    private Statement statement;

    private ResultSet result;



    public DataBaseConnection(){

        try{
            //step1 load the driver class
            Class.forName(mysql);
            //step2 create  the connection object
            connection = DriverManager.getConnection(mysqlurl,"root","");
            //step3 create the statement object
            statement = connection.createStatement();

        }

        catch (ClassNotFoundException e) {
            /*e.printStackTrace();*/
            System.out.println("Class Missing");
        }catch (Exception e){
            System.out.println("NOT COnnected");
        }

    }


    public int inupdatedel(String q){
        try {
            return statement.executeUpdate(q);
        } catch (SQLException e) {
            System.out.println("Error Sql");
        }catch (Exception e){
            System.out.println("Error");
        }
        return 0;
    }

    public ResultSet selectQuery(String q){
        try {
            return   result = statement.executeQuery(q);
        } catch (SQLException e) {
            System.out.println("Error Sql in result");
        }catch (Exception e){
            System.out.println("Error");
        }
        return null;
    }

}
