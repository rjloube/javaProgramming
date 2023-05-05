package application;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    private HashMap<Integer, Double> yearlyInterestValues = new HashMap<>();
    private HashMap<Integer, Double> monthlySavingsValues = new HashMap<>();

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {

        // 1 Create main BorderPane
        BorderPane mainBorderPane = new BorderPane();
        mainBorderPane.setPadding(new Insets(20, 20, 20, 20));

        // 1.1 Add LineChart to center of BorderPane
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis();
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setLegendVisible(false);
        mainBorderPane.setCenter(lineChart);

        // 1.2 Create Data Series for LineChart
        XYChart.Series monthlySavingsData = new XYChart.Series();
        lineChart.getData().add(monthlySavingsData);

        XYChart.Series yearlyInterestData = new XYChart.Series();
        lineChart.getData().add(yearlyInterestData);

        // 1.3 Initially populate monthly savings data and yearly interest data
        // Both will be identical, as initial interest rate is zero
        this.populateInitialData(monthlySavingsData);
        this.populateInitialData(yearlyInterestData);

        // 2 Add VBox containing two BorderPanes to top of main BorderPane
        VBox vBox = new VBox();
        mainBorderPane.setTop(vBox);

        // 2.1 Create top BorderPane and child components
        // 2.1.1 Create Label, Slider, text describing slider for top BorderPane of VBox
        Label monthlySavingsTitle = new Label("Monthly savings");

        Slider monthlySavingsSlider = new Slider(25, 250, 25);
        monthlySavingsSlider.setShowTickMarks(true);
        monthlySavingsSlider.setShowTickLabels(true);
        monthlySavingsSlider.setMajorTickUnit(25);
        monthlySavingsSlider.setMinorTickCount(3);

        Label monthlySavingsValue = new Label();
        monthlySavingsValue.setText(String.valueOf(monthlySavingsSlider.getValue()));

        // 2.2 Create bottom BorderPane and child components
        // 2.2.1 Create Label, Slider, and text describing slider for bottom BorderPane of VBox
        Label yearlyInterestLabel = new Label("Yearly interest rate");

        Slider yearlyInterestSlider = new Slider(0, 10, 5);
        yearlyInterestSlider.setShowTickMarks(true);
        yearlyInterestSlider.setShowTickLabels(true);
        yearlyInterestSlider.setMajorTickUnit(10);
        yearlyInterestSlider.setMinorTickCount(0);
        Label yearlyInterestValue = new Label();
        yearlyInterestSlider.setValue(0);
        yearlyInterestValue.setText(String.valueOf(yearlyInterestSlider.getValue()));

        // 2.1.2 Add event handling for text describing slider and line chart
        // HashMap<Integer, Double> monthlySavingsValues = new HashMap<>();
        monthlySavingsSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            monthlySavingsValue.setText(String.valueOf(Math.round(((double) newValue) * 10.0) / 10.0));

            monthlySavingsValues.put(0, 0.0);

            for (int i = 1; i <= 30; i++) {
                monthlySavingsValues.put(i, monthlySavingsSlider.getValue() * (i * 12));
            }

            monthlySavingsData.getData().clear();

            monthlySavingsValues.entrySet().stream().forEach(value -> {
                monthlySavingsData.getData().add(new XYChart.Data(value.getKey(), value.getValue()));

            });

            this.updateYearlyInterestData(yearlyInterestData, monthlySavingsSlider, yearlyInterestSlider);

        });

        // 2.1.3 Add child components to top BorderPane
        BorderPane monthlySavingsLayout = new BorderPane();
        monthlySavingsLayout.setPadding(new Insets(20, 20, 20, 20));
        monthlySavingsLayout.setLeft(monthlySavingsTitle);
        monthlySavingsLayout.setCenter(monthlySavingsSlider);
        monthlySavingsLayout.setRight(monthlySavingsValue);

        // 2.2.2 Add event handling for text describing slider and line chart
        // HashMap<Integer, Double> yearlyInterestValues = new HashMap<>();
        yearlyInterestSlider.valueProperty().addListener((change, oldValue, newValue) -> {
            yearlyInterestValue.setText(String.valueOf(Math.round(((double) newValue) * 10.0) / 10.0));

            this.updateYearlyInterestData(yearlyInterestData, monthlySavingsSlider, yearlyInterestSlider);

            /*
            yearlyInterestValues.put(0, 0.0);

            for (int i = 0; i <= 30; i++) {
                yearlyInterestValues.put(i, this.calculateCompoundInterest((int) monthlySavingsSlider.getValue() * 12, i, yearlyInterestSlider.getValue() / 100, 1));
            }

            yearlyInterestData.getData().clear();

            yearlyInterestValues.entrySet().stream().forEach(value -> {
                yearlyInterestData.getData().add(new XYChart.Data(value.getKey(), value.getValue()));
            });
             */
        });

        // 2.2.3 Add child components to bottom BorderPane
        BorderPane yearlyInterestLayout = new BorderPane();
        yearlyInterestLayout.setPadding(new Insets(20, 20, 20, 20));
        yearlyInterestLayout.setLeft(yearlyInterestLabel);
        yearlyInterestLayout.setCenter(yearlyInterestSlider);
        yearlyInterestLayout.setRight(yearlyInterestValue);

        // 2.3 Add top and bottom BorderPanes to VBox
        vBox.getChildren().add(monthlySavingsLayout);
        vBox.getChildren().add(yearlyInterestLayout);

        Scene scene = new Scene(mainBorderPane);
        window.setScene(scene);
        window.show();
    }

    public void populateInitialData(XYChart.Series data) {
        monthlySavingsValues.put(0, 0.0);

        for (int i = 1; i <= 30; i++) {
            monthlySavingsValues.put(i, (double) 25 * (i * 12));
        }

        data.getData().clear();

        monthlySavingsValues.entrySet().stream().forEach(value -> {
            data.getData().add(new XYChart.Data(value.getKey(), value.getValue()));
        });
    }

    public void updateYearlyInterestData(XYChart.Series data, Slider monthlySavingsSlider, Slider yearlyInterestSlider) {
        yearlyInterestValues.put(0, 0.0);

        for (int i = 0; i <= 30; i++) {
            yearlyInterestValues.put(i, this.calculateCompoundInterest((int) monthlySavingsSlider.getValue() * 12, i, yearlyInterestSlider.getValue() / 100, 1));
        }

        data.getData().clear();

        yearlyInterestValues.entrySet().stream().forEach(value -> {
            data.getData().add(new XYChart.Data(value.getKey(), value.getValue()));

        });
    }

    public double calculateCompoundInterest(int p, int t, double r, int n) {
        double amount = p * Math.pow(1 + (r / n), n * t);
        System.out.println("Amount after " + t + " years: " + amount);
        return amount;
    }

}
