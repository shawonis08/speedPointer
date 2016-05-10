package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Header;

/**
 * Created by Shahidul on 5/2/2016.
 */

public class HowToPlay{

    private  Header header;
    private  Rectangle rectangle;
    private Label label ;
    private Text text;
    private Stage stage;
    private Scene scene;

    public HowToPlay(){

        stage = new Stage();

        header = new Header();

        rectangle = new Rectangle(0,560,500,40);
        rectangle.setFill(Paint.valueOf("#a0e71e"));

        label = new Label("How To Play");
        label.setLayoutX(129);
        label.setLayoutY(215);
        label.setFont(Font.font("Times New Roman",42));

        text = new Text(80,330,"Press LeftArrow Key to shift ball left & Press RightArrow Key to shift ball right");
        text.setWrappingWidth(400);
        /*text.setLayoutX(0);
        text.setLayoutY(300);*/
        text.setFont(Font.font("Times New Roman",22));

        Group root = new Group(header.head(),label,text,rectangle);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }
}
