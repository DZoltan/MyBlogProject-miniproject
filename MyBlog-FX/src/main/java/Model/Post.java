package Model;

import lombok.Data;

import java.util.List;

@Data
public class Post {
    private String id;
    private String title;
    private String user;
    private String date;
    private String status;
    private String description;
    private List<Comment> comments;

}
