package UIElements;

import Model.Comment;
import Model.Post;
import javafx.scene.control.Label;
import javafx.scene.layout.*;


public class KommentPanel extends StackPane {

    Label description = new Label();
    Label author = new Label();

    public KommentPanel(Comment comment){

        //Initialize data
        this.author.setText(comment.getUser());
        this.description.setText(comment.getDescription());
    }

}
