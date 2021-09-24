package UIElements;

import Model.Post;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class KommentPanel extends StackPane {

    Label title = new Label();
    Label description = new Label();
    Label author = new Label();
    Label status = new Label();

    public KommentPanel(Post post){

        //Initialize data
        this.title.setText(post.getTitle());
        this.author.setText(post.getUser());
        this.description.setText(post.getDescription());
        this.status.setText(post.getStatus().toString());
    }

}
