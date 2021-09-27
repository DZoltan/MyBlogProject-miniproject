package Controller;

import Model.Comment;
import Model.Post;
import UIElements.KommentPanel;
import UIElements.NodePanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentController {

    public String username;
    public List<Comment> comments = new ArrayList<>();

    @FXML
    private Label authorLabel;
    @FXML
    private Label statusLabel;
    @FXML
    private ScrollPane scroll;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField commentField;

    private PostController postController;
    public Post post;


    public void init(Post post, String username, PostController postController){
        this.post = post;
        this.username = username;
        authorLabel.setText("Szerző : " + post.getUser());
        statusLabel.setText("Státusz : " +post.getStatus().toString());
        descriptionLabel.setText(post.getDescription());
        titleLabel.setText(post.getTitle());
        this.postController = postController;
        comments = post.getComments();
        addNodeToSP();
    }

    public void addNodeToSP() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        /*try {
            for (Comment comment : comments) {
                KommentPanel node = new KommentPanel(comment, this);
                root.getChildren().addAll(node);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        for (Comment comment : comments) {
            KommentPanel node = new KommentPanel(comment, this);
            root.getChildren().addAll(node);

        scroll.setContent(root);

        }
    }

    public void deleteComment(Comment comment){
        comments.remove(comment);
        postController.updateJson();
        scroll.setContent(null);
        addNodeToSP();
    }

    public int getNewId(){
        if(comments.size() == 0) {
            return 0;
        }
        else {
            return comments.stream().mapToInt(Comment::getId).max().orElseThrow() + 1;
        }
    }
    public void sendComment(ActionEvent actionEvent) {
        comments.add(new Comment(getNewId(), username, LocalDate.now().toString(), commentField.getText()));
        postController.updateJson();
        scroll.setContent(null);
        addNodeToSP();
    }

}
