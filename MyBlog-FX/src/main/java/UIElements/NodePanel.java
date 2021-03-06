package UIElements;

import Controller.CommentController;
import Controller.PostController;
import Model.Post;

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
import lombok.Data;
import lombok.SneakyThrows;

import java.io.IOException;

@Data
public class NodePanel extends StackPane {
    Label title = new Label();
    Label description = new Label();
    Label author = new Label();
    Label status = new Label();
    Label date = new Label();
    Button delete = new Button();
    Button expand = new Button();

    public NodePanel(Post post, PostController postController) throws IOException {

        //Initialize data
        this.title.setText(post.getTitle());
        this.author.setText("Írta: " + post.getUser());
        this.description.setText(post.getDescription());
        this.status.setText(post.getStatus().toString());
        this.date.setText("Dátum: " + post.getDate());

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

        //date
        date.setFont(new Font("Arial", 14));
        date.setPadding(new Insets(0,60,10,0));
        this.getChildren().add(date);
        this.setAlignment(date,Pos.BOTTOM_RIGHT);


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

            //status modify
            Button setStatus = new Button("Státusz módosítása");
            this.getChildren().add(setStatus);
            this.setAlignment(setStatus, Pos.BOTTOM_LEFT);
            setStatus.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    postController.listDialog(post);
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
                FXMLLoader fxmlLoader = new FXMLLoader(CommentController.class.getResource("/fxs/postWindow.fxml"));
                Parent root = fxmlLoader.load();
                CommentController comment = fxmlLoader.<CommentController>getController();
                comment.init(post, postController.userName, postController);
                stage.setScene(new Scene(root));
                stage.setResizable(false);
                stage.show();
            }
        });


    }

}
