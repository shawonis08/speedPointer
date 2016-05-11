package view;

import javafx.application.Platform;
import javafx.css.CssMetaData;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Bar;
import model.CustomButton;
import model.Header;
import service.DataBaseService;

/**
 * Created by Shahidul on 5/3/2016.
 */


public class Level1 {

    private Stage stage;
    private Header header;
    private Rectangle rectangle,bar1,bar2;
    private Line mainline;
    private Circle ball;
    private Scene scene;
    private Bar barL1,barR1,barL2,barR2;
    private boolean gameover;
    private static int c=0;
    private Group game=new Group(),gameoverGroup=new Group(),root=new Group();
    private static int score = 0;
    private static Label scoreshow;
    private Label gameLabel,scoreLAbel;
    private CustomButton backButton;


    private String logedplyer;


    public void setScore() {
        this.score = ++score;
    }
    public Level1(int a){
    }


    public Level1() {


        stage = new Stage();

        header = new Header();


        /*Games Design*/
        mainline = new Line(250, 180, 250, 560);

        ball = new Circle(250, 520, 10);

        barL1 = new Bar(100, 10, ball, scene, 2);
        barL1.setLayoutX(150);
        barL1.setLayoutY(180);


        barR1 = new Bar(100, 10, ball, scene, 2);
        barR1.setLayoutX(250);
        barR1.setLayoutY(250);

        barL2 = new Bar(100, 10, ball, scene, 2);
        barL2.setLayoutX(150);
        barL2.setLayoutY(320);

        barR2 = new Bar(100, 10, ball, scene,2);
        barR2.setLayoutX(250);
        barR2.setLayoutY(390);

        scoreshow = new Label("SCORE : 0");
        scoreshow.setFont(Font.font("TIMES NEW ROMAN",18));
        scoreshow.setLayoutY(570);
        scoreshow.setLayoutX(240);

        /*Footer*/
        rectangle = new Rectangle(0, 560, 500, 40);
        rectangle.setFill(Paint.valueOf("#a0e71e"));

        gameLabel=new Label("");
        gameLabel=new Label("");
        gameLabel.setLayoutX(200);
        gameLabel.setLayoutY(100);

        scoreLAbel=new Label("");
        scoreLAbel.setLayoutX(221);
        scoreLAbel.setLayoutY(150);


        gameoverGroup.getChildren().addAll(gameLabel,scoreLAbel);


        backButton = new CustomButton(3,140,"Back",18);
        backButton.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new GameMenu();
        });


        game.getChildren().addAll(mainline, ball, barL1, barR1,barR2, barL2,backButton,gameoverGroup);
        root = new Group(header.head(), game, rectangle,scoreshow);
        scene = new Scene(root, 500, 600);


        scene.addEventFilter(KeyEvent.KEY_PRESSED, e -> {
            if (e.getCode() == KeyCode.LEFT) {
                if (ball.getLayoutX() > -50) {
                    ball.setLayoutX(ball.getLayoutX() - 50);
                }
            } else if (e.getCode() == KeyCode.RIGHT) {
                if (ball.getLayoutX() < 50) {
                    ball.setLayoutX(ball.getLayoutX() + 50);
                }
            }

        });
        /*Back to default position*/
        scene.addEventFilter(KeyEvent.KEY_RELEASED, e -> {
            if (e.getCode() == KeyCode.LEFT) {
                ball.setLayoutX(ball.getLayoutX() + 50);
            } else if (e.getCode() == KeyCode.RIGHT) {
                ball.setLayoutX(ball.getLayoutX() - 50);
            }
        });
        stage.setScene(scene);
        stage.show();

    }
    public String getLogedplyer() {
        return logedplyer;
    }

    public void setLogedplyer(String logedplyer) {
        this.logedplyer = logedplyer;
    }


    public void gameplayinfo(){
        setScore();

        scoreshow.setText("SCORE : "+String.valueOf(score));


    }

    public void gameOver(){
//        gameoverGroup.setVisible(true);
//        game.setVisible(false);
        gameLabel=new Label("GAME OVER");

        //scoreLAbel.setText("SCORE : "+String.valueOf(score));
        DataBaseService dataBaseService=new DataBaseService();
        Login login=new Login(1);
        dataBaseService.updatescore(login.getLogeduser(),score);
        //login.getLogeduser()




    }
}