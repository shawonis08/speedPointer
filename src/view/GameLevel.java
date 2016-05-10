package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.CustomButton;
import model.Header;

/**
 * Created by Shahidul on 5/3/2016.
 */
public class GameLevel {

    private Stage stage;
    private Header header;
    private Rectangle rectangle;
    private Text text;
    private Stop[] stops;
    private LinearGradient linearGradient;
    private Line line1,line2;
    private CustomButton easy,medium,hard;
    private Scene scene;

    public GameLevel(){

        stage = new Stage();

        /*header rectangle1*/

        header = new Header();


        easy = new CustomButton(150, 225, "Easy", 26);
        easy.setPrefWidth(220);
        easy.setPrefHeight(68);

        easy.setOnAction(e->{

            ((Node) (e.getSource())).getScene().getWindow().hide();
          Level1 level1=  new Level1();
           // level1.setLogedplyer();
        });


        medium = new CustomButton(150, 325, "Medium", 26);
        medium.setPrefWidth(220);
        medium.setPrefHeight(68);

        medium.setOnAction(e->{
            ((Node) (e.getSource())).getScene().getWindow().hide();
            /*new Level2();*/
        });

        hard = new CustomButton(150, 425, "Hard", 26);
        hard.setPrefWidth(220);
        hard.setPrefHeight(68);

        /*hard.setOnAction(e->{
            ((Node) (e.getSource())).getScene().getWindow().hide();
            new Level3();
        });*/

        /*footer rectangle3*/
        line2 = new Line(0, 520, 500, 520);

        rectangle = new Rectangle(0, 521, 500, 80);
        rectangle.setFill(Paint.valueOf("#a0e71e"));

        Group root = new Group(header.head(), easy, medium, hard, line2, rectangle);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();

    }
}
