package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by Shahidul Islam on 5/8/2016.
 */
public class loginWarn {
    private Label warn;
    private Stage stage;
    private Scene scene;

    public loginWarn(){

        stage = new Stage();


        warn = new Label("Invalid Username or Password.Please try again!!");
        warn.setLayoutX(16);
        warn.setLayoutY(27);
        warn.prefHeight(72);
        warn.prefWidth(458);
        warn.setFont(Font.font("Times New Roman",22));


        Group root = new Group(warn);
        scene = new Scene(root,480,60);
        stage.setScene(scene);
        stage.show();

        //copy from stack
    }
}
