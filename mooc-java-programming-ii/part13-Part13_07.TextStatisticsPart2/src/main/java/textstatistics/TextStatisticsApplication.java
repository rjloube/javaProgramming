package textstatistics;

import java.util.Arrays;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextStatisticsApplication extends Application {

    public static void main(String[] args) {
        launch(TextStatisticsApplication.class);
    }

    @Override
    public void start(Stage window) {
        BorderPane view = new BorderPane();

        HBox textComponents = new HBox();
        textComponents.setSpacing(10);
        Label lettersLabel = new Label("Letters: 0");
        textComponents.getChildren().add(lettersLabel);
        Label wordsLabel = new Label("Words: 0");
        textComponents.getChildren().add(wordsLabel);
        Label longestWordLabel = new Label("The longest word is: ");
        textComponents.getChildren().add(longestWordLabel);
        view.setBottom(textComponents);

        TextArea textArea = new TextArea("");
        view.setCenter(textArea);
        
        textArea.textProperty().addListener((change, oldValue, newValue) -> {
            int characters = newValue.length();
            String[] parts = newValue.split(" ");
            int words = parts.length;
            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            
            lettersLabel.setText("Letters: " + characters);
            wordsLabel.setText("Words: " + words);
            longestWordLabel.setText("The longest word is: " + longest);
        });

        Scene scene = new Scene(view);

        window.setScene(scene);

        window.show();

    }

}
