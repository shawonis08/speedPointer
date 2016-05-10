package model;

import javafx.scene.control.Button;
import javafx.scene.text.Font;

/**
 * Created by Shahidul on 5/1/2016.
 */
public class CustomButton extends Button {

    public CustomButton(double x, double y, String text) {
        super.setLayoutX(x);
        super.setLayoutY(y);
        super.setText(text);
        super.setFont(Font.font("Halo3",25));
    }

    public CustomButton(double x, double y, String text, int s) {
        this(x, y, text);
        this.setFont(Font.font("Halo3", s));
    }

    public CustomButton(double x, double y, String text, String z, int s) {
        this(x, y, text);
        this.setFont(Font.font(z, s));
    }
}
