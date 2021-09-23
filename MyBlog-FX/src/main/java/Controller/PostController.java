package Controller;

import Model.Post;
import Model.SeriDeseri;
import UIElements.NodePanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class PostController {

    @FXML
    private ScrollPane scroll;
    private SeriDeseri seriDeseri;

    public void login(ActionEvent actionEvent) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Login");
        alert.showAndWait();

        addNodeToSP();

    }

    public void search(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("search");
        alert.showAndWait();
    }

    public void logout(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("logout");
        alert.showAndWait();
    }

    public void addNodeToSP() throws IOException {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        seriDeseri = new SeriDeseri();
        List postList = seriDeseri.DeSerialize(new File("sample.json"));

        for (int i = 0; i < 10; i++){
            NodePanel node = null;
            Post post = (Post) postList.iterator().next();
            try {
                node = new NodePanel(post);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            root.getChildren().addAll(node);
        }


        scroll.setContent(root);
    }
}
