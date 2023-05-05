package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) {
        
        // 1. Creating view asking for a name
        
        // 1.1 Creating the UI components
        Label instructionText = new Label("Enter your name and start.");
        TextField nameField = new TextField();
        Button startButton = new Button("Start");
        
        // 1.2 Creating the layout and adding UI components to it
        GridPane layout = new GridPane();
        layout.add(instructionText, 0, 0);
        layout.add(nameField, 0, 1);
        layout.add(startButton, 0, 2);
        
        // 1.3 Styling the layout
        layout.setPrefSize(300, 180);
        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        
        // 1.4 Creating the view itself and setting it to use the layout
        Scene nameView = new Scene(layout);
        
        // 2. Creating a view for showing the welcome message
        
        // TO DO: add entered name
        Label welcomeText = new Label("");
        
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(welcomeText);
        welcomeLayout.setAlignment(Pos.CENTER);
        
        Scene welcomeView = new Scene(welcomeLayout);
        
        // 3. Adding event handler to the Start button.
        // The view is changed when a user submits a name.
        startButton.setOnAction((event) -> {
            String name = nameField.getText();
            welcomeText.setText("Welcome " + name + "!");
            window.setScene(welcomeView);
        });
        
        // 4. Setting the default view
        window.setScene(nameView);
        window.show();
        
        
        
    }
}
