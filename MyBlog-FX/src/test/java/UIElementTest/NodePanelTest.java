package UIElementTest;

import Controller.PostController;
import Model.Post;
import UIElements.NodePanel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class NodePanelTest {

    @Test
    void testNewNodePanelInitialization() throws IOException {

        PostController postController = new PostController();
        Post post = new Post();

        post.setTitle("The Success");
        post.setUser("Billy");
        post.setDescription("Something");
        post.setDate(LocalDate.now().toString());

        NodePanel nodePanel = new NodePanel(post, postController);

        assertEquals(nodePanel.getTitle(),post.getTitle());
        assertEquals(nodePanel.getAuthor(),post.getUser());
        assertEquals(nodePanel.getDescription(),post.getDescription());
        assertEquals(nodePanel.getDate(),post.getDate(),LocalDate.now().toString());

    }
}
