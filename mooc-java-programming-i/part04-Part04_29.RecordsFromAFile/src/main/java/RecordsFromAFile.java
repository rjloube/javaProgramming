
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        try ( Scanner fileReader = new Scanner(Paths.get(file))) {
            while (fileReader.hasNextLine()) {
                String[] pieces = (fileReader.nextLine()).split(",");
                String name = pieces[0];
                int year = Integer.valueOf(pieces[1]);
                if (year == 1) {
                    System.out.println(name + ", " + year + " year");
                } else {
                    System.out.println(name + ", " + year + " years");
                }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
