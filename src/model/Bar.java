package model;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import view.GameOver;
import view.Level1;
import view.Level2;

public class Bar extends Rectangle implements Runnable{

    private Rectangle rectangle;
    private Scene scene;
    private Thread thisThread;
    private double x;
    private double y;
    private double speed;
    private Circle ball;
    private Bar barR;
    private static boolean stop = false;
    Level1 level1 = new Level1(1);
    Level2 level2 = new Level2(1) ;



    public Bar (double x, double y, Circle ball, Scene scene, int s){
        super(x,y,Color.web("#000"));
        this.scene = scene;
        this.x = x;
        this.y = y;
        thisThread = new Thread(this);
        thisThread.start();
        this.setSpeed(s);
        this.ball = ball;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }




    public void run(){
        while (this.isVisible() && !stop){
                Platform.runLater(() -> {
                    this.setLayoutY(this.getLayoutY() + speed);
                    if(!(ball.getBoundsInParent().intersects(this.getBoundsInParent()))){
                        if (this.getLayoutY() > 600) {
                            level1.gameplayinfo();

                            //level1.getScoreshow().setText(String.valueOf(score++));
                            this.setLayoutY(200);
                        }

                    }
                    else {

                        System.out.println("Game over");
                        this.setVisible(false);
                        stop = true;
                        level1.gameOver();
                        new GameOver();

                    }
                    });
                try {
                    thisThread.sleep(20);
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }
    }
}