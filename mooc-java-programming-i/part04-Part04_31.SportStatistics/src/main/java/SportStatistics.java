
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("File:");
        String file = scan.nextLine();

        System.out.println("Team:");
        String team = scan.nextLine();

        try (Scanner fileReader = new Scanner(Paths.get(file))) {
            int count = 0;
            int wins = 0;
            int losses = 0;
            
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] pieces = line.split(",");
                String homeName = pieces[0];
                String awayName = pieces[1];
                int homeScore = Integer.valueOf(pieces[2]);
                int awayScore = Integer.valueOf(pieces[3]);
                
                if (team.equals(homeName)) {
                    count++;
                    if (homeScore > awayScore) {
                        wins++;
                    } else {
                        losses++;
                    }
                }
                
                if (team.equals(awayName)) {
                    count++;
                    if (awayScore > homeScore) {
                        wins++;
                    } else {
                        losses++;
                    }
                }
                
            }
            
            System.out.println("Games: " + count);
            System.out.println("Wins: " + wins);
            System.out.println("Losses: " + losses);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }

}
