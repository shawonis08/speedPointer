package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.CustomButton;
import model.Header;

/**
 * Created by Shahidul on 5/3/2016.
 */
public class MainMenuCopy {
    private Stage stage;
    private Header header;
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Text text;
    private Stop[] stops;
    private LinearGradient linearGradient;
    private Line line1;
    private Line line2;
    private CustomButton playonline;
    private CustomButton playoffline;
    private Scene scene;

    public MainMenuCopy(){

        stage = new Stage();

        /*header rectangle1*/

        header = new Header();

        /*body rectangle2*/

        stops = new Stop[]{new Stop(1, Color.WHITE), new Stop(0, Color.web("#a0e71e"))};
        linearGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
        rectangle1 = new Rectangle(0, 181, 500, 338);
        rectangle1.setFill(linearGradient);

        //button 1
        playonline = new CustomButton(150, 248, "Play Online", 24);
        playonline.setPrefWidth(220);
        playonline.setPrefHeight(68);

        playonline.setOnAction(e -> {
            ((Node) (e.getSource())).getScene().getWindow().hide();
            new Login();
        });

        //button2
        playoffline = new CustomButton(150, 358, "Play Offline", 24);
        playoffline.setPrefWidth(220);
        playoffline.setPrefHeight(68);

        playoffline.setOnAction(e -> {
            ((Node) (e.getSource())).getScene().getWindow().hide();
            new GameMenu();
        });

        /*footer rectangle3*/
        line2 = new Line(0, 520, 500, 520);
        rectangle2 = new Rectangle(0, 521, 500, 80);
        rectangle2.setFill(Paint.valueOf("#a0e71e"));

        Group root = new Group(header.head(), rectangle1, playonline, playoffline, line2, rectangle2);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();

    }
}
