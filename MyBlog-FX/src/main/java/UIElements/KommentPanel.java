package UIElements;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class KommentPanel extends StackPane {
    Button back = new Button();

    public KommentPanel() {

        //back
        Image backImage = new Image(this.getClass().getResourceAsStream("/imgs/back.png"));
        back.setGraphic(new ImageView(backImage));
        this.getChildren().add(back);
        this.setAlignment(back, Pos.BOTTOM_RIGHT);

    }
}
