package Application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Shifan
 */
@Controller
@RequestMapping(path = "/board")
public class BoardController {

    @GetMapping
    public String getRequest() {
        return "board";
    }

    @ResponseBody
    @PostMapping
    public String postRequest(@RequestBody String string) throws IOException {
        JsonNode object = null;
        ObjectMapper mapper = new ObjectMapper();
        object = mapper.readTree(string);

        File tmpDir = new File("src/main/resources/static/data.json");
        String tempString = "";
        Scanner sc;

        saveToJSON(object, tmpDir);

        try {
            sc = new Scanner(tmpDir);

            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");
        }
        try {
            readJSONFromFile(tmpDir);
            tempString = readJSONFromFile(tmpDir).toString();
        } catch (IOException ex) {
            System.out.println("error");
        }
        return tempString;

    }

    public void saveToJSON(JsonNode jn, File f) {

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(f, jn);
        } catch (IOException ex) {
        }
    }

    public JsonNode readJSONFromFile(File f) throws FileNotFoundException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode model = mapper.readTree(f);
        return model;
    }
}
