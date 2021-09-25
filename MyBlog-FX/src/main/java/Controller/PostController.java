package Controller;

import Model.Comment;
import Model.Post;
import Model.SeriDeseri;
import Model.Status;
import UIElements.NodePanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class PostController {

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label welcome;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button searchBtn;

    public String userName = new String();
    public SeriDeseri seriDeseri = new SeriDeseri();
    public List<Post> postList = new ArrayList<>();

    public void init() {
        if(userName.isBlank()){
            welcome.setText("Kérem jelentkezzen be!");
        }
        try {
            postList = seriDeseri.DeSerialize(new File("sample.json"));
            System.out.println(postList.size());

        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Elérési hiba");
            alert.setContentText("Az adatbázis nem elérhető!");
            alert.showAndWait();
        }
    }


    public void login(ActionEvent actionEvent) {
        loginDialog();
        searchBtn.setVisible(true);
        logoutBtn.setVisible(true);
        addNodeToSP();

    }

    public void search(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("search");
        alert.showAndWait();
    }

    public void logout(ActionEvent actionEvent) {
        userName = "";
        scroll.setContent(null);
        searchBtn.setVisible(false);
        logoutBtn.setVisible(false);
        init();
    }



    public void addNodeToSP() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        try {
            for (Post post : postList) {
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
        
        
        
     //Dialog ablak (logdialog = login dialog)
     public void loginDialog() {
        TextInputDialog logdialog = new TextInputDialog();
        logdialog.setTitle("Belépés");
        logdialog.setHeaderText(null);
        logdialog.setContentText("Kérem adja meg a nevét:");
         Optional<String> result = logdialog.showAndWait();
         if (result.isPresent())
             userName = result.orElseThrow();
             welcome.setText("Üdvözlünk, " + userName);
    }



// Törlés alert (delalert)
    public void deleteDialog(Post post) {
        Alert delalert = new Alert(Alert.AlertType.CONFIRMATION);
        delalert.setTitle("Törlés");
        delalert.setHeaderText(null);
        delalert.setContentText("A " + post.getTitle() + " törlődni fog, biztosan ezt szeretnéd?");

        Optional<ButtonType> result = delalert.showAndWait();
        if (result.get() == ButtonType.OK) {
            postList.remove(post);
            seriDeseri.Serialize(postList);
            scroll.setContent(null);
            addNodeToSP();
        }
    }

/*


// Szöveg lehetőségek elészítése és hozzáadása
*/
    public void newPost() {
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Bejegyzés");
        dialog.setHeaderText(null);

        ButtonType doneButton = new ButtonType("Kész", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(doneButton, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setPrefSize(300,200);
        grid.setPadding(new Insets(10, 10, 10, 10));

        TextField title = new TextField();
        title.setPromptText("Cím");
        TextArea description = new TextArea();
        description.setPrefSize(200,200);
        description.setWrapText(true);
        description.setPromptText("Leírás");

        grid.add(new Label("Cím:"), 0, 0);
        grid.add(title, 1, 0);
        grid.add(new Label("Leírás:"), 0, 1);
        grid.add(description, 1, 1);


        dialog.getDialogPane().setContent(grid);

        Optional<Pair<String, String>> result = dialog.showAndWait();

        setNewPost(title.getText(), description.getText());
    }

    public int getNewId(){
        if(postList.size() == 0) {
            return 0;
        }
        else {
            return postList.stream().mapToInt(Post::getId).max().orElseThrow() + 1;
        }
    }

    public void setNewPost(String title, String description){
        List<Comment> emptyComment = new ArrayList<>();
        Post newPost = new Post(getNewId(), title, userName, LocalDate.now().toString(), Status.TO_DO, description, emptyComment);
        postList.add(newPost);
        seriDeseri.Serialize(postList);
        scroll.setContent(null);
        addNodeToSP();

    }
                        
        

}
