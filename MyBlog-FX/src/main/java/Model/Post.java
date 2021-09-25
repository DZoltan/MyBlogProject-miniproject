package Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class Post {
    private int id;
    private String title;
    private String user;
    private String date;
    private Status status;
    private String description;
    private List<Comment> comments;

}
