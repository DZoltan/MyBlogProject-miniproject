package Model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SeriDeseri {

    static ObjectMapper objectMapper = new ObjectMapper();

    public static void Serialize(List posts){
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("Sample.json"), posts);
        }
        catch (Exception e){}
    }

    public static ArrayList DeSerialize(File JSONfile) throws IOException {
        return objectMapper.readValue(JSONfile, new TypeReference<ArrayList<Post>>(){});
    }

}
