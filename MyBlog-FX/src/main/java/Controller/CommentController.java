package Controller;

import Model.Comment;
import Model.Post;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

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


    public void init(Post post, String username){
        this.username = username;
        authorLabel.setText("Szerző :" + post.getUser());
    }

    public void sendComment(ActionEvent actionEvent) {
    }
}
