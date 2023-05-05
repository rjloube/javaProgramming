
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

//throws IOException

public class LiteracyComparison {

    public static void main(String[] args) {

        ArrayList<String> rows = new ArrayList<>();

        try {
            Files.lines(Paths.get("literacy.csv")).forEach(row -> rows.add(row));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        rows.stream()
                .map(row -> row.split(","))
                .sorted((r1, r2) -> r1[5].compareTo(r2[5]))
                .forEach(row -> System.out.println(row[3].trim() + " (" + row[4] + "), " + row[2].split(" ")[1].trim() + ", " + row[5].trim()));

    }
}
