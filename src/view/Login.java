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

public class Login {

    private  Header header;
    private  Rectangle rectangle;
    private  Text username,password,msg, warn;
    private  TextField userfield;
    private  PasswordField passwordField;
    private  CustomButton login,register;
    private  Stage stage;
    private Scene scene;

    private static String logeduser;
    public Login(int a){

    }

    public Login (){

        stage = new Stage();

        header = new Header();


        username = new Text(80,230,"Username/Email");
        username.setFont(Font.font("Times New Roman",18));
        userfield = new TextField();
        userfield.setLayoutX(77);
        userfield.setLayoutY(260);
        userfield.setPrefWidth(300);

        password = new Text(80,320,"Password");
        password.setFont(Font.font("Times New Roman",18));
        passwordField = new PasswordField();
        passwordField.setLayoutX(77);
        passwordField.setLayoutY(335);
        passwordField.setPrefWidth(300);

        login = new CustomButton(80,379,"Login","Times New Roman",14);
        login.setPrefHeight(30);
        login.setPrefWidth(78);

        warn = new Text(80,550,"username or password not valid");
        warn.setFont(Font.font("Times New Roman",18));
        warn.setVisible(false);


        login.setOnAction(e->{
            if(check()==false || login() == false){
                ((Node)(e.getSource())).getScene().getWindow().hide();
                new Login();
                new Warn();

            }
            if(check()==true && login()==true) {
                ((Node)(e.getSource())).getScene().getWindow().hide();
                new GameMenu();
            }
        });

        msg = new Text(77,450,"If you don't have any account click Register");
        msg.setFont(Font.font("Times New Roman",16));

        register = new CustomButton(80,479,"Register","Times New Roman",14);
        register.setPrefHeight(30);
        register.setPrefWidth(78);

        register.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new Register();
        });


        /*footer*/
        rectangle = new Rectangle(0,560,500,40);
        rectangle.setFill(Paint.valueOf("#a0e71e"));



        Group root = new Group(header.head(),username,userfield,password,passwordField,login,msg,register,warn,rectangle);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }

    public boolean login(){
        String u,p;
        u = userfield.getText();
        p =  passwordField.getText();
        setLogeduser(u);
        DataBaseService db = new DataBaseService();
        System.out.println(getLogeduser());
        return db.playerLogin(u,p);
    }

    public boolean check(){
        if(userfield.getText().isEmpty() && passwordField.getText().isEmpty()){
            return false;
        }
        else
            return true;
    }


    public String getLogeduser() {
        return logeduser;
    }

    public void setLogeduser(String logeduser) {
        this.logeduser = logeduser;
    }

}
