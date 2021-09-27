package UIElements;

import Controller.CommentController;
import Model.Comment;
import Model.Post;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.awt.*;


public class KommentPanel extends StackPane {

    Label description = new Label();
    Label author = new Label();
    Button delete = new Button();
    Comment comment = new Comment();
    CommentController commentController = new CommentController();

    public KommentPanel(Comment comment , CommentController commentController){

        this.author.setText(comment.getUser());
        this.description.setText(comment.getDescription());
        this.setPrefSize(500,20);
        this.comment = comment;
        this.commentController = commentController;
        initLabels();
        initButton();
    }

    public void initLabels(){
        author.setVisible(true);
        author.setPrefSize(100, 20);
        description.setVisible(true);
        description.setPrefSize(400, 20);
        this.getChildren().add(author);
        this.setAlignment(author, Pos.CENTER_LEFT);
        this.getChildren().add(description);
        this.setAlignment(description, Pos.CENTER);
    }

    public void initButton(){
        if(comment.getUser().compareTo(commentController.username) == 0) {

            Image deleteImage = new Image(this.getClass().getResourceAsStream("/imgs/delete.png"));
            delete.setGraphic(new ImageView(deleteImage));
            this.getChildren().add(delete);
            this.setAlignment(delete, Pos.CENTER_RIGHT);
            delete.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    commentController.deleteComment(comment);
                }
            });
        }
    }

}
