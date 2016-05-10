package view;

import javafx.scene.Group;
import javafx.scene.Scene;

import model.Header;

/**
 * Created by Shahidul on 5/2/2016.
 */

public class MainGame1 {
    private static Scene sceneg1;
    private static Header header;

    public  Group maing1() {

        header = new Header();

        Group root = new Group();
        root.getChildren().addAll(header.head());
        return root;
    }

}
