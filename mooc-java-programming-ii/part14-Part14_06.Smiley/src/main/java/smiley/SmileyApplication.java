package smiley;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        
        Canvas paintingCanvas = new Canvas(800, 800);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();
        borderPane.setCenter(paintingCanvas);
        
        painter.setFill(Color.BLACK);
        painter.fillRect(275, 50, 50, 50);
        painter.fillRect(575, 50, 50, 50);
        painter.fillRect(175, 250, 50, 50);
        painter.fillRect(675, 250, 50, 50);
        
        // painter.fillRect(225, 300, 50, 50);
        for (int i = 225; i <= 625; i = i + 25) {
            painter.fillRect(i, 300, 50, 50);
        }
        
        
        Scene scene = new Scene(borderPane);
        stage.setScene(scene);
        stage.show();
        

    }

    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}
