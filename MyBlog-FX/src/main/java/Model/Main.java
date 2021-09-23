package Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        SeriDeseri seriDeseri = new SeriDeseri();

        Post post = new Post();
        Post post1 = new Post();
        Comment comment = new Comment();
        Comment comment1 = new Comment();

        ArrayList<Comment> listComment = new ArrayList<Comment>();
        ArrayList<Post> listPost = new ArrayList<Post>();

        comment.setId("1");
        comment.setUser("Laci");
        comment.setDate("2021");
        comment.setDescription("Szép voooooolt.");

        comment1.setId("1");
        comment1.setUser("Arpi");
        comment1.setDate("2021");
        comment1.setDescription("Szép volt.");

        listComment.add(comment);
        listComment.add(comment1);

        post.setTitle("Testing");
        post.setDate("2021");
        post.setStatus(Status.IN_PROGRESS);
        post.setDescription("Serializálás tesztelés");
        post.setId("1");
        post.setUser("Pista");
        post.setComments(listComment);

        post1.setTitle("Test");
        post1.setDate("2021");
        post1.setStatus(Status.DONE);
        post1.setDescription("Serializáció");
        post1.setId("2");
        post1.setUser("Géza");
        post1.setComments(listComment);

        listPost.add(post);
        listPost.add(post1);

        seriDeseri.Serialize(listPost);

        File file = new File("sample.json");

        List<Post> postList = seriDeseri.DeSerialize(file);

        postList.forEach(x -> System.out.println(x.toString()));


    }
}