import Controller.PostController;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class BlogStart extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("MyBlog");
        FXMLLoader fxmlLoader = new FXMLLoader(PostController.class.getResource("/fxs/mainWindow.fxml"));
        Parent root = fxmlLoader.load();
        PostController post = fxmlLoader.<PostController>getController();
        post.init();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }
}
