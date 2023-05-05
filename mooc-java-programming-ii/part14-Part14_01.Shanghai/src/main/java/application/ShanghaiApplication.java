package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) {

        // Create axes for chart
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);

        // Set titles for axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");

        // Create the line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai Ranking");

        // Create data to be used for line chart
        XYChart.Series rankingData = new XYChart.Series();

        // TEST
        rankingData.getData().add(new XYChart.Data(2007, 73));
        rankingData.getData().add(new XYChart.Data(2008, 68));
        rankingData.getData().add(new XYChart.Data(2009, 72));
        rankingData.getData().add(new XYChart.Data(2010, 72));
        rankingData.getData().add(new XYChart.Data(2011, 74));
        rankingData.getData().add(new XYChart.Data(2012, 73));
        rankingData.getData().add(new XYChart.Data(2013, 76));
        rankingData.getData().add(new XYChart.Data(2014, 73));
        rankingData.getData().add(new XYChart.Data(2015, 67));
        rankingData.getData().add(new XYChart.Data(2016, 56));
        rankingData.getData().add(new XYChart.Data(2017, 56));

        // Fetch data for line chart
        // Create scanner for reading file
        /*
        try ( Scanner scanner = new Scanner(Paths.get("C:\\delicious\\Shanghai.txt"));) {
            // Read all lines of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                // Add data in current line to Series
                String[] parts = line.split(" ");
                int year = Integer.valueOf(parts[0]);
                int ranking = Integer.valueOf(parts[1]);
                System.out.println("Year: " + year + ", Ranking: " + ranking);
                rankingData.getData().add(new XYChart.Data(year, ranking));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         */
        // Add the data set to the line chart
        lineChart.getData().add(rankingData);
        lineChart.setLegendVisible(false);

        // Display line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();

        System.out.println(rankingData.getData());

    }

}
