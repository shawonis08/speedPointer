package view;

/**
 * Created by Shahidul Islam on 5/8/2016.
 */

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;

public class GameOver {
    private Stage stage;
    private Text gameovertext;
    private Scene scene;

    public GameOver(){
        stage = new Stage();
        gameovertext = new Text(8,50,"Game Over");
        gameovertext.setFont(Font.font("Halo3",25));

        Group root = new Group(gameovertext);
        scene = new Scene(root,200,100);
        stage.setScene(scene);
        stage.show();
    }
}


