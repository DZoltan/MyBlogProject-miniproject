package Controller;

import Model.Comment;
import Model.Post;
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


    public void init(Post post, String username){
        this.username = username;
        authorLabel.setText("Szerző :" + post.getUser());

    }

    public void addNodeToSP() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        try {
            for (Post post : comments) {
                NodePanel node = new NodePanel(post, this);
                root.getChildren().addAll(node);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        scroll.setContent(root);

    }
    public int getNewId(){
        if(comments.size() == 0) {
            return 0;
        }
        else {
            return comments.stream().mapToInt(Post::getId).max().orElseThrow() + 1;
        }
    }
    public void sendComment(ActionEvent actionEvent) {
        
    }
    public void newPost() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Hozzászólás");
        dialog.setHeaderText(null);

        ButtonType doneButton = new ButtonType("Kész", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(doneButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setPrefSize(300,200);
        grid.setPadding(new Insets(10, 10, 10, 10));

        TextField title = new TextField();
        TextArea description = new TextArea();
        description.setPrefSize(200,200);
        description.setWrapText(true);
        description.setPromptText("Leírás");
        
        grid.add(new Label("Leírás:"), 0, 1);
        grid.add(description, 1, 1);


        dialog.getDialogPane().setContent(grid);

        Optional<Pair<String, String>> result = dialog.showAndWait();

        setNewPost(title.getText(), description.getText());
    }
}
