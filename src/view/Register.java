package view;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.CustomButton;
import model.Header;
import service.DataBaseService;


/**
 * Created by Shahidul on 5/2/2016.
 */
public class Register {
    private  Header header;
    private  Rectangle rectangle;
    private  Text username,email,password;
    private  TextField userfield,emailfield;
    private  PasswordField passwordField;
    private  CustomButton register;
    private  Stage stage;
    private Scene scene;
    private DataBaseService dataBaseService;

    public Register(){

        stage = new Stage();
        header = new Header();

        username = new Text(72,230,"Username");
        username.setFont(Font.font("Times New Roman",18));
        userfield = new TextField();
        userfield.setLayoutX(72);
        userfield.setLayoutY(250);
        userfield.setPrefWidth(300);

        email = new Text(72,300,"Email");
        email.setFont(Font.font("Times New Roman",18));
        emailfield = new TextField();
        emailfield.setLayoutX(72);
        emailfield.setLayoutY(320);
        emailfield.setPrefWidth(300);

        password = new Text(72,370,"Password");
        password.setFont(Font.font("Times New Roman",18));
        passwordField = new PasswordField();
        passwordField.setLayoutX(72);
        passwordField.setLayoutY(390);
        passwordField.setPrefWidth(300);

        register = new CustomButton(72,450,"Register","Times New Roman",14);
        register.setPrefHeight(30);
        register.setPrefWidth(78);

        register.setOnAction(e->{
            register();
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Login();
        });

        /*Footer*/
        rectangle = new Rectangle(0,560,500,40);
        rectangle.setFill(Paint.valueOf("#a0e71e"));

        Group root = new Group(header.head(),username,userfield,email,emailfield,password,passwordField,register,rectangle);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();

    }
    public void register(){
        String u,e,p;
        u = userfield.getText();
        p =  passwordField.getText();
        e = emailfield.getText();
        DataBaseService db = new DataBaseService();
        db.playerRegistration(u,e,p);
    }

}