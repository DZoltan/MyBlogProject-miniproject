package UIElements;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class NodePanel extends StackPane {
    Label title = new Label("Teszt");
    Label description = new Label();
    public NodePanel(){
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPrefSize(430,200);
        this.setPadding(new Insets(10));

        //Title
        title.setFont(new Font("Verdana", 20));
        //title.setPadding(new Insets(10));
        this.getChildren().add(title);
        this.setAlignment(title,Pos.TOP_CENTER);

        //Description
        description.setFont(new Font("Verdana", 16));
        description.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla imperdiet, nunc ac consectetur pellentesque," +
                " mi sem aliquam orci, at faucibus purus libero sed purus. Donec ut orci in augue suscipit lobortis. Sed maximus imperdiet augue. " +
                "Suspendisse maximus dui augue, in porttitor tellus fringilla non. Sed vel orci dapibus, varius ipsum a, volutpat mauris. Ut consequat ipsum id " +
                "gravida pulvinar. Fusce nec leo ut metus egestas scelerisque ac ut dui. Vestibulum sagittis sem sed eros fringilla, eu sodales urna tempor. Aenean rutrum laoreet nisl, " +
                "maximus ultricies nisi consequat sit amet. Aenean tincidunt tellus eget neque molestie ullamcorper. Integer aliquet dignissim bibendum.Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Nulla imperdiet, nunc ac consectetur pellentesque, mi sem aliquam orci, at faucibus purus libero sed purus. Donec ut orci in augue suscipit lobortis. Sed maximus imperdiet " +
                "augue. Suspendisse maximus dui augue, in porttitor tellus fringilla non. Sed vel orci dapibus, varius ipsum a, volutpat mauris. Ut consequat ipsum id gravida pulvinar. " +
                "Fusce nec leo ut metus egestas scelerisque ac ut dui. Vestibulum sagittis sem sed eros fringilla, eu sodales urna tempor. Aenean rutrum laoreet nisl, maximus ultricies nisi consequat sit amet." +
                " Aenean tincidunt tellus eget neque molestie ullamcorper. Integer aliquet dignissim bibendum.");
        description.setWrapText(true);
        description.setPadding(new Insets(15));
        this.getChildren().add(description);
        this.setAlignment(description,Pos.CENTER);
    }

}
