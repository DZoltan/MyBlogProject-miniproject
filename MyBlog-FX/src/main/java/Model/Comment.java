package Model;

import lombok.Data;

@Data
public class Comment {
    private String id;
    private String user;
    private String date;
    private String description;

}
