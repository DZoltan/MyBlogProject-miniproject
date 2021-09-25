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
import java.util.ArrayList;
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
        ArrayList<Post> postList = seriDeseri.DeSerialize(new File("sample.json"));

            try {
                for(Post post: postList) {
                    NodePanel node = new NodePanel(post);
                    root.getChildren().addAll(node);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        scroll.setContent(root);
        
        
        
        
        
     //Dialog ablak (logdialog = login dialog)        
TextInputDialog logdialog = new TextInputDialog();
logdialog.setTitle("Belépés");
logdialog.setHeaderText(null);
logdialog.setContentText("Kérem adja meg a nevét:");

//Szöveg bekérése és visszaadása
Optional<String> result = logdialog.showAndWait();
if (result.isPresent())
    System.out.println("Your name: " + result.get());





// Törlés alert (delalert)
Alert delalert = new Alert(AlertType.CONFIRMATION);
delalert.setTitle("Törlés");
delalert.setHeaderText(null);
delalert.setContentText("A ... törlődni fog, biztosan ezt szeretnéd?");

Optional<ButtonType> result = delalert.showAndWait();
if (result.get() == ButtonType.OK){
    // A felhasználó megnyomta az OK gombot
} else {
    // A felhasználó megnyomta a Cancel gombot, vagy bezárta az ablakot
}



// 2 szöveges dialog
Dialog<Pair<String, String>> dialog = new Dialog<>();
dialog.setTitle("Bejegyzés");
dialog.setHeaderText(null);


// Gombok megadása
ButtonType doneButton = new ButtonType("Kész", ButtonData.OK_DONE);
dialog.getDialogPane().getButtonTypes().addAll(doneButton, ButtonType.CANCEL);

// Szöveg lehetőségek elészítése és hozzáadása
GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(20, 150, 10, 10));

TextField title = new TextField();
title.setPromptText("Cím");
TextField description = new TextField();
description.setPromptText("Leírás");

grid.add(new Label("Cím:"), 0, 0);
grid.add(title, 1, 0);
grid.add(new Label("Leírás:"), 0, 1);
grid.add(description, 1, 1);


dialog.getDialogPane().setContent(grid);


Optional<Pair<String, String>> result = dialog.showAndWait();   
        
        
                        
        
    }
}
