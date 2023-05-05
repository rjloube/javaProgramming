package ticTacToe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeApplication extends Application {

    private TurnTracker turnTracker;

    @Override
    public void start(Stage stage) {
        
        //Create turn tracker
        this.turnTracker = new TurnTracker();
        
        // Master UI component
        BorderPane layout = new BorderPane();

        // Text field showing information on whose turn it is
        Label turnInformation = new Label("Turn: " + this.turnTracker.getCurrentTurn());
        turnInformation.setFont(Font.font("Monospaced", 40));
        layout.setTop(turnInformation);

        // GridPane for the the board
        GridPane board = new GridPane();
        board.setAlignment(Pos.CENTER);
        layout.setCenter(board);

        // Buttons and event handlers for each spot on the board
        Button topLeft = new Button(" ");
        topLeft.setFont(Font.font("Monospaced", 40));
        board.add(topLeft, 0, 0);
        pressButton(topLeft, turnInformation, board);

        Button topMiddle = new Button(" ");
        topMiddle.setFont(Font.font("Monospaced", 40));
        board.add(topMiddle, 1, 0);
        pressButton(topMiddle, turnInformation, board);

        Button topRight = new Button(" ");
        topRight.setFont(Font.font("Monospaced", 40));
        board.add(topRight, 2, 0);
        pressButton(topRight, turnInformation, board);

        Button middleLeft = new Button(" ");
        middleLeft.setFont(Font.font("Monospaced", 40));
        board.add(middleLeft, 0, 1);
        pressButton(middleLeft, turnInformation, board);

        Button middleMiddle = new Button(" ");
        middleMiddle.setFont(Font.font("Monospaced", 40));
        board.add(middleMiddle, 1, 1);
        pressButton(middleMiddle, turnInformation, board);

        Button middleRight = new Button(" ");
        middleRight.setFont(Font.font("Monospaced", 40));
        board.add(middleRight, 2, 1);
        pressButton(middleRight, turnInformation, board);

        Button bottomLeft = new Button(" ");
        bottomLeft.setFont(Font.font("Monospaced", 40));
        board.add(bottomLeft, 0, 2);
        pressButton(bottomLeft, turnInformation, board);

        Button bottomMiddle = new Button(" ");
        bottomMiddle.setFont(Font.font("Monospaced", 40));
        board.add(bottomMiddle, 1, 2);
        pressButton(bottomMiddle, turnInformation, board);

        Button bottomRight = new Button(" ");
        bottomRight.setFont(Font.font("Monospaced", 40));
        board.add(bottomRight, 2, 2);
        pressButton(bottomRight, turnInformation, board);

        Scene scene = new Scene(layout, 300, 300);

        stage.setScene(scene);
        stage.show();

    }

    public void pressButton(Button button, Label label, GridPane board) {
        button.setOnAction((event) -> {
            if (button.getText().equals(" ")) {
                button.setText(this.turnTracker.getCurrentTurn());
                this.turnTracker.takeTurn(GridPane.getRowIndex(button), GridPane.getColumnIndex(button));
                if (this.turnTracker.checkForWinner()) {
                    label.setText("The end!");
                    deactivateButtons(board);

                } else {
                    label.setText("Turn: " + this.turnTracker.getCurrentTurn());
                }
                // this.turnTracker.printLedger();

            }
        });
    }

    public void deactivateButtons(GridPane board) {
        for (Node node : board.getChildren()) {
            node.setDisable(true);
        }
    }
    public static void main(String[] args) {
        launch(TicTacToeApplication.class);
    }

}
