package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.CustomButton;
import model.Header;

/**
 * Created by Shahidul on 5/11/2016.
 */
public class GameMenuOffline {
    private Header header;
    private CustomButton newgame,highscore,howtoplay,logout;
    private Rectangle rectangle;
    private Stage stage;
    private Scene scene;



    public GameMenuOffline() {

        stage = new Stage();

        header = new Header();

        newgame = new CustomButton(175,235,"New Game",18);
        newgame.setPrefWidth(190);
        newgame.setPrefHeight(50);

        newgame.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new GameLevel();
        });


        howtoplay = new CustomButton(175,315,"How To Play",18);
        howtoplay.setPrefWidth(190);
        howtoplay.setPrefHeight(50);

        howtoplay.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new HowToPlay();
        });


        logout = new CustomButton(175,395,"Back",18);
        logout.setPrefWidth(190);
        logout.setPrefHeight(50);

        logout.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new MainMenuCopy();
        });


        /*Footer*/
        rectangle = new Rectangle(0,560,500,40);
        rectangle.setFill(Paint.valueOf("#a0e71e"));

        Group root = new Group(header.head(),newgame,howtoplay,logout,rectangle);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();


    }
}
