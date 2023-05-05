/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe;

/**
 *
 * @author rjloube
 */
public class TurnTracker {

    private String turn;
    private String[][] board;

    public TurnTracker() {
        this.turn = "X";
        this.board = new String[3][3];
        
        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board.length; column++) {
                this.board[row][column] = String.valueOf(row) + ", " + String.valueOf(column);
            }
        }
    }

    public void takeTurn(int row, int column) {

        // Mark ledger with the turn just taken
        this.board[row][column] = this.turn;

        // Switch whose turn it is
        if (this.turn.equals("X")) {
            this.turn = "O";
        } else if (this.turn.equals("O")) {
            this.turn = "X";
        }
    }

    public String getCurrentTurn() {
        return this.turn;
    }

    public void printLedger() {
        for (int row = 0; row < this.board.length; row++) {
            for (int column = 0; column < this.board.length; column++) {
                String value = this.board[row][column];
                System.out.println("" + row + ", " + column + ", " + value);
            }
        }
        System.out.println("===");
    }

    public boolean checkForWinner() {
        
        // Check the rows
        for (int row = 0; row < this.board.length; row++) {
            if (this.board[row][0].equals(this.board[row][1])
                    && this.board[row][0].equals(this.board[row][2])) {
                return true;
            }
        }

        
        // Check the columns
        for (int column = 0; column < this.board.length; column++) {
            if (this.board[0][column].equals(this.board[1][column])
                    && this.board[0][column].equals(this.board[2][column])) {
                return true;
            }
        }
        
        // Check the diagonals
        if (this.board[0][0].equals(this.board[1][1])
                && this.board[0][0].equals(this.board[2][2])) {
            return true;
        }
        
        return this.board[2][0].equals(this.board[1][1])
                && this.board[2][0].equals(this.board[0][2]);
    }

}
