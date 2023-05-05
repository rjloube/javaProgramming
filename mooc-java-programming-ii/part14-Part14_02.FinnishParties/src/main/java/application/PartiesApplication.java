package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    private static final Logger logger = Logger.getLogger(PartiesApplication.class.getName());

    public static void main(String[] args) {
        logger.setLevel(Level.FINEST);
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) {

        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);

        xAxis.setLabel("Year");
        yAxis.setLabel("Relative Support (%)");

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");

        HashMap<String, HashMap<Integer, Double>> partiesData = new HashMap<>();
        ArrayList<Integer> years = new ArrayList<>();

        try ( Scanner scanner = new Scanner(Paths.get("partiesdata.tsv"))) {
            if (scanner.hasNextLine()) {
                String header = scanner.nextLine();
                String[] pieces = header.split("\t");
                for (int i = 1; i < pieces.length; i++) {
                    years.add(Integer.valueOf(pieces[i]));
                }
                logger.log(Level.INFO, "Years saved to List: " + years.toString());
            }

            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                String[] pieces = row.split("\t");
                HashMap<Integer, Double> yearAndSupport = new HashMap<>();
                for (int i = 1; i <= years.size(); i++) {
                    if ((!pieces[i].equals("-"))) {
                        yearAndSupport.put(years.get(i - 1), Double.valueOf(pieces[i]));
                    }
                }

                partiesData.put(pieces[0], yearAndSupport);
            }
            logger.log(Level.INFO, "Master HashMap: " + partiesData.toString());

        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        partiesData.keySet().stream().forEach(party -> {
            XYChart.Series data = new XYChart.Series();
            data.setName(party);

            partiesData.get(party).entrySet().stream().forEach(pair -> {
                data.getData().add(new XYChart.Data(pair.getKey(), pair.getValue()));
            });

            lineChart.getData().add(data);
        });

        Scene view = new Scene(lineChart);
        stage.setScene(view);
        stage.show();

    }
}
