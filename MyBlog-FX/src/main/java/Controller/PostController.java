package Controller;

import Model.Comment;
import Model.Post;
import Model.SeriDeseri;
import Model.Status;
import UIElements.NodePanel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;


public class PostController {

    @FXML
    private ScrollPane scroll;

    @FXML
    private Label welcome;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button searchBtn;
    @FXML
    private Button newPostBtn;

    public String userName = new String();
    public SeriDeseri seriDeseri = new SeriDeseri();
    public ArrayList<Post> postList = new ArrayList<Post>();

    public void init() {
        if(userName.isBlank()){
            welcome.setText("Kérem jelentkezzen be!");
        }
        try {
            postList = seriDeseri.DeSerialize(new File("sample.json"));

        }
        catch (IOException e){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Elérési hiba");
            alert.setContentText("Az adatbázis nem elérhető!" + e);
            alert.showAndWait();
            System.out.println(e);
        }
    }


    public void login(ActionEvent actionEvent) {
        if(loginDialog()){
            searchBtn.setVisible(true);
            logoutBtn.setVisible(true);
            newPostBtn.setVisible(true);
            addNodeToSP();
        }

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
        newPostBtn.setVisible(false);
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
     public boolean loginDialog() {
        TextInputDialog logdialog = new TextInputDialog();
        logdialog.setTitle("Belépés");
        logdialog.setHeaderText(null);
        logdialog.setContentText("Kérem adja meg a nevét:");
         Optional<String> result = logdialog.showAndWait();
         if (!result.orElseThrow().isBlank()){
             userName = result.orElseThrow();
             welcome.setText("Üdvözlünk, " + userName);
             return true;}
         return false;


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
            return postList.stream().mapToInt(Post::getId).max().orElseThrow();
        }
    }

    public void setNewPost(String title, String description){
        List<Comment> emptyComment = new ArrayList<>();
        Post newPost = new Post( getNewId(), title, userName, LocalDate.now().toString(), Status.TO_DO, description, emptyComment);
        postList.add(newPost);
        seriDeseri.Serialize(postList);
        scroll.setContent(null);
        addNodeToSP();

    }
    
    
    public void listDialog(Post post) {

    ChoiceDialog<Status> dialog = new ChoiceDialog<>();
    dialog.getItems().addAll(Status.values());
    dialog.setTitle("Opciók");
    dialog.setHeaderText(null);
    dialog.setContentText("Válasszon az alábbi opciók közül");

    Optional<Status> result = dialog.showAndWait();
    if (result.isPresent()){
        post.setStatus(result.orElseThrow());
        seriDeseri.Serialize(postList);
        scroll.setContent(null);
        addNodeToSP();
         System.out.println("A választása:" + result.get());
    }

}

                        
        

}
