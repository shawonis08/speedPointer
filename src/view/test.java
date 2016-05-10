package view;

import data.DataBaseConnection;
import javafx.scene.shape.Rectangle;
import service.DataBaseService;

/**
 * Created by Shahidul on 5/5/2016.
 */
public class test {

    public static void main(String args[]){
        DataBaseService db = new DataBaseService();
        /*db.playerRegistration("s","ss","ss");*/
        System.out.println(db.playerLogin("s","ss"));

        Rectangle rectangle = new Rectangle(500,300);

    }
}
