
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadingFilesPerLine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test the method here
        
        System.out.println(read("C:\\html\\myfirstpage.html"));

    }

    public static List<String> read(String file) {

        ArrayList<String> rows = new ArrayList<>();

        try {
            Files.lines(Paths.get(file)).forEach(row -> rows.add(row));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        return rows;
    }

}
