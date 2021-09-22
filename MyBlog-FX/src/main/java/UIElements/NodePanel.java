package UIElements;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.IOException;


public class NodePanel extends StackPane {
    Label title = new Label("Teszt");
    Label description = new Label();
    Button delete = new Button();
    Button expand = new Button();

    public NodePanel() throws IOException {
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPrefSize(430,200);
        this.setPadding(new Insets(5));

        //Title
        title.setFont(new Font("Verdana", 20));
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

        //delete button
        Image deleteImage = new Image(this.getClass().getResourceAsStream("/imgs/delete.png"));
        delete.setGraphic(new ImageView(deleteImage));
        this.getChildren().add(delete);
        this.setAlignment(delete, Pos.TOP_RIGHT);

        //Expand button
        Image expandImage = new Image(this.getClass().getResourceAsStream("/imgs/expand.png"));
        expand.setGraphic(new ImageView(expandImage));
        this.getChildren().add(expand);
        this.setAlignment(expand, Pos.BOTTOM_RIGHT);
        expand.setOnAction(new EventHandler<ActionEvent>() {
            @SneakyThrows
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxs/post.fxml"));
                Parent root = fxmlLoader.load();
                stage.setScene(new Scene(root));
                stage.show();
            }
        });


    }

}
