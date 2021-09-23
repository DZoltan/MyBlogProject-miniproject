package Model;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        comment.setId("1");
        comment.setUser("Laci");
        comment.setDate(dateFormat.format(date));
        comment.setDescription("Szép voooooolt.");

        comment1.setId("1");
        comment1.setUser("Arpi");
        comment1.setDate(dateFormat.format(date));
        comment1.setDescription("Szép volt.");

        listComment.add(comment);
        listComment.add(comment1);

        post.setTitle("Testing");
        post.setDate(dateFormat.format(date));
        post.setStatus(Status.IN_PROGRESS);
        post.setDescription("Serializálás tesztelés");
        post.setId("1");
        post.setUser("Pista");
        post.setComments(listComment);

        post1.setTitle("Test");
        post1.setDate(dateFormat.format(date));
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