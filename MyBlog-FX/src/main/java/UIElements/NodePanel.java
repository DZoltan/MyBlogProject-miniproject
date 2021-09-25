package UIElements;

import Controller.CommentController;
import Controller.PostController;
import Model.Post;
import com.sun.prism.shader.Solid_Color_Loader;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.geometry.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import lombok.SneakyThrows;

import java.io.IOException;


public class NodePanel extends StackPane {
    Label title = new Label();
    Label description = new Label();
    Label author = new Label();
    Label status = new Label();
    Button delete = new Button();
    Button expand = new Button();

    public NodePanel(Post post, PostController postController) throws IOException {

        //Initialize data
        this.title.setText(post.getTitle());
        this.author.setText(post.getUser());
        this.description.setText(post.getDescription());
        this.status.setText(post.getStatus().toString());

        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPrefSize(440,200);
        this.setPadding(new Insets(10));

        //Title
        title.setFont(new Font("Verdana", 20));
        title.setPadding(new Insets(10,0,0,0));
        this.getChildren().add(title);
        this.setAlignment(title,Pos.TOP_CENTER);

        //Description
        description.setFont(new Font("Verdana", 14));
        description.setPrefSize(340,120);
        description.setWrapText(true);
        description.setPadding(new Insets(15));
        this.getChildren().add(description);
        this.setAlignment(description,Pos.CENTER);

        //author
        author.setFont(new Font("Arial", 16));
        author.setPadding(new Insets(0,60,25,0));
        this.getChildren().add(author);
        this.setAlignment(author,Pos.BOTTOM_RIGHT);

        //status
        status.setFont(new Font("Arial", 20));
        status.setPadding(new Insets(10,0,0,10));
        this.getChildren().add(status);
        this.setAlignment(status, Pos.TOP_LEFT);


        if(post.getUser().compareTo(postController.userName) == 0) {
            //delete button
            Image deleteImage = new Image(this.getClass().getResourceAsStream("/imgs/delete.png"));
            delete.setGraphic(new ImageView(deleteImage));
            this.getChildren().add(delete);
            this.setAlignment(delete, Pos.TOP_RIGHT);
            delete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    postController.deleteDialog(post);
                }
            });
        }
        //Expand button
        Image expandImage = new Image(this.getClass().getResourceAsStream("/imgs/expand.png"));
        expand.setGraphic(new ImageView(expandImage));
        this.getChildren().add(expand);
        this.setAlignment(expand, Pos.BOTTOM_RIGHT);
        expand.setOnAction(new EventHandler<ActionEvent>() {
            @SneakyThrows
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                System.out.println(getClass().getResource("/fxs/postWindow.fxml").getPath());
                stage.setTitle("Post");
                Parent root = FXMLLoader.load(getClass().getResource("/fxs/postWindow.fxml"));
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
                new KommentPanel(post);
            }
        });


    }

}
