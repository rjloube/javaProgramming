package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) {

        // First View
        Label firstViewLabel = new Label("First view!");
        Button firstViewButton = new Button("To the second view!");

        BorderPane borderpane = new BorderPane();
        borderpane.setTop(firstViewLabel);
        borderpane.setCenter(firstViewButton);

        Scene firstView = new Scene(borderpane);

        // Second View
        Button secondViewButton = new Button("To the third view!");
        Label secondViewText = new Label("Second view!");

        VBox vBox = new VBox();
        vBox.getChildren().addAll(secondViewButton, secondViewText);

        Scene secondView = new Scene(vBox);

        // Third View
        GridPane gridPane = new GridPane();
        Label secondViewLabel = new Label("Third view!");
        gridPane.add(secondViewLabel, 0, 0);
        Button thirdViewButton = new Button("To the first view!");
        gridPane.add(thirdViewButton, 1, 1);
        
        Scene thirdView = new Scene(gridPane);

        // Transitions
        firstViewButton.setOnAction((event) -> {
            window.setScene(secondView);
        });
        
        secondViewButton.setOnAction((event) -> {
            window.setScene(thirdView);
        });

        thirdViewButton.setOnAction((event) -> {
            window.setScene(firstView);
        });

        // Stage
        window.setScene(firstView);
        window.show();
    }

}
