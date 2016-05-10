package view;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.CustomButton;
import model.Header;
import model.OnlinePlayer;
import service.DataBaseService;

/**
 * Created by Shahidul on 5/2/2016.
 */

public class Score {

    private  Header header;
    private  Rectangle rectangle;
    private Label label;
    private Stage stage;
    private Scene scene;
    private VBox root;
    private DataBaseService dataBaseService;
    private CustomButton backButton;


    public Score(){

        stage = new Stage();

        header = new Header();
        dataBaseService=new DataBaseService();

        rectangle = new Rectangle(0,560,500,40);
        rectangle.setFill(Paint.valueOf("#a0e71e"));

        label = new Label("HIGH SCORE");
        label.setLayoutX(129);
        label.setLayoutY(215);
        label.setFont(Font.font("Times New Roman",42));




		// Creating the TableView object
		TableView table = new TableView();
        table.setItems(FXCollections.observableArrayList(dataBaseService.playerScore()));
		 // Creating the columns
		TableColumn nameColumn = new TableColumn("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<OnlinePlayer,String>("Username"));
		TableColumn scoreColumn = new TableColumn("Score");
        scoreColumn.setCellValueFactory(new PropertyValueFactory<OnlinePlayer,String>("Score"));
        nameColumn.setPrefWidth(150);
        scoreColumn.setPrefWidth(150);
        nameColumn.setStyle("-fx-alignment: CENTER;");
        scoreColumn.setStyle("-fx-alignment: CENTER;");

        table.getColumns().addAll(nameColumn,scoreColumn);

        backButton = new CustomButton(3,140,"Back",18);
        backButton.setOnAction(e->{
            ((Node)(e.getSource())).getScene().getWindow().hide();
            new GameMenu();
        });



        VBox vBox = new VBox(5);
		/*Box.setPadding(new Insets(100));*/
        vBox.setLayoutY(300);
        vBox.setLayoutX(130);
        vBox.setMaxHeight(250);
        vBox.getChildren().addAll(table);




        Group root = new Group(header.head(),label,vBox,backButton,rectangle);
        scene = new Scene(root,500,600);
        stage.setScene(scene);
        stage.show();
    }
}
