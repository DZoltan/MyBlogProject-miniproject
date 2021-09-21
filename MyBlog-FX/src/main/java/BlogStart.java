import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

public class BlogStart extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        System.out.println(getClass().getResource("/fxs/mainWindow.fxml").getPath());
        stage.setTitle("MyBlog");
        Parent root = FXMLLoader.load(getClass().getResource("/fxs/mainWindow.fxml"));
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();

    }
}
