package view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import model.CustomButton;

/**
 * Created by Shahidul on 5/1/2016.
 */
public class    Page1 extends Application{
    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private Text text;
    private Stop[] stops;
    private LinearGradient linearGradient;
    private Line line1;
    private Line line2;
    private CustomButton customButton1;


    public void start (Stage stage){

        /*header rectangle1*/
        rectangle1 = new Rectangle(500,180);
        rectangle1.setFill(Paint.valueOf("#a0e71e"));

        text = new Text(81,104,"SpeedPointer");
        text.setFont(Font.font("Halo3",50));

        line1 = new Line(0,180,500,180);

        /*body rectangle2*/

        stops = new Stop[] { new Stop(1, Color.WHITE), new Stop(0, Color.web("#a0e71e"))};
        linearGradient = new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, stops);
        rectangle2 = new Rectangle(0,181,500,338);
        rectangle2.setFill(linearGradient);

        //button 1
        customButton1 = new CustomButton(150,248,"Play Online",24);

        /*footer rectangle3*/
        line2 = new Line(0,520,500,520);
        rectangle3 = new Rectangle(0,521,500,80);
        rectangle3.setFill(Paint.valueOf("#a0e71e"));

        /* stage & scene */
        Group root = new Group(rectangle1,text,line1,rectangle2,customButton1,line2,rectangle3);
        Scene scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }
}
