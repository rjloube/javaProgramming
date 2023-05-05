package collage;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {

    @Override
    public void start(Stage stage) {

        // the example opens the image, creates a new image, and copies the opened image
        // into the new one, pixel by pixel
        Image sourceImage = new Image("file:monalisa.png");

        PixelReader imageReader = sourceImage.getPixelReader();

        int width = (int) sourceImage.getWidth();
        int height = (int) sourceImage.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter imageWriter = targetImage.getPixelWriter();

        int yCoordinate = 0;
        while (yCoordinate < height) {
            int xCoordinate = 0;
            while (xCoordinate < width) {

                Color color = imageReader.getColor(xCoordinate, yCoordinate);
                double red = color.getRed();
                double green = color.getGreen();
                double blue = color.getBlue();
                double opacity = color.getOpacity();

                // Write negative colors of sourceImage
                Color newColor = new Color(1.0 - red, 1.0 - green, 1.0 - blue, opacity);

                // imageWriter.setColor(xCoordinate, yCoordinate, newColor);
                imageWriter.setColor(xCoordinate / 2, yCoordinate / 2, newColor);
                imageWriter.setColor(width / 2 + xCoordinate / 2, yCoordinate / 2, newColor);
                imageWriter.setColor(xCoordinate / 2, height / 2 + yCoordinate / 2, newColor);
                imageWriter.setColor(width / 2 + xCoordinate / 2, height / 2 + yCoordinate / 2, newColor);

                // xCoordinate++;
                xCoordinate += 2;
            }

            // yCoordinate++;
            yCoordinate += 2;
        }

        // Master image
        ImageView image = new ImageView(targetImage);

        // Top left image
        // ImageView topLeftImage = this.quarterImage(targetImage, 0, 0);
        // Top right image
        // ImageView topRightImage = this.quarterImage(targetImage, 1, 0);
        // Bottom left image
        // ImageView bottomLeftImage = this.quarterImage(targetImage, 0, 1);
        // Bottom right image
        // ImageView bottomRightImage = this.quarterImage(targetImage, 1, 1);
        // Bottom left image
        // Add all images to Pane
        Pane pane = new Pane();
        pane.getChildren().add(image);
        // pane.getChildren().add(topLeftImage);
        // pane.getChildren().add(topRightImage);
        // pane.getChildren().add(bottomLeftImage);
        // pane.getChildren().add(bottomRightImage);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public ImageView quarterImage(Image targetImage, int x, int y) {
        ImageView quarterImage = new ImageView(targetImage);
        quarterImage.setScaleX(0.5);
        quarterImage.setScaleY(0.5);

        if (x == 0) {
            quarterImage.setTranslateX(-((targetImage.getWidth() - (targetImage.getWidth() / 2)) / 2));
        } else if (x == 1) {
            quarterImage.setTranslateX((targetImage.getWidth() - (targetImage.getWidth() / 2)) / 2);
        }

        if (y == 0) {
            quarterImage.setTranslateY(-((targetImage.getHeight() - (targetImage.getHeight() / 2)) / 2));
        } else if (y == 1) {
            quarterImage.setTranslateY((targetImage.getHeight() - (targetImage.getHeight() / 2)) / 2);
        }

        return quarterImage;
    }

}
