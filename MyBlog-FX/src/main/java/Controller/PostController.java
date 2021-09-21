package Controller;

import UIElements.NodePanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.awt.*;

import static javafx.geometry.Pos.CENTER;

public class PostController {

    @FXML
    private ScrollPane scroll;

    public void login(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Login");
        alert.showAndWait();

        addNodeToSP();
        addNodeToSP();
        addNodeToSP();
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

    public void addNodeToSP(){
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        for (int i = 0; i < 50; i++){
            NodePanel node = new NodePanel();
            root.getChildren().addAll(node);
        }


        scroll.setContent(root);
    }
}
