
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfColumns() {

        ArrayList<Integer> sumOfRows = new ArrayList<>();

        for (int row = 0; row < this.square.length; row++) {
            int sumOfRow = 0;
            for (int column = 0; column < this.square[row].length; column++) {
                sumOfRow += this.square[row][column];
            }
            sumOfRows.add(sumOfRow);
        }
        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumOfColumns = new ArrayList<>();

        for (int column = 0; column < this.square[0].length; column++) {
            int sumOfColumn = 0;
            for (int row = 0; row < this.square.length; row++) {
                sumOfColumn += this.square[row][column];
            }

            sumOfColumns.add(sumOfColumn);
        }

        return sumOfColumns;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sumOfDiagonals = new ArrayList<>();

        // First diagonal
        int backSlash = 0;
        for (int row = 0; row < this.square.length; row++) {
            backSlash += this.square[row][row];
        }
        sumOfDiagonals.add(backSlash);

        // Second diagonal
        int forwardSlash = 0;
        for (int row = 0; row < this.square.length; row++) {
            forwardSlash += this.square[row][this.square[row].length - (row + 1)];
        }
        sumOfDiagonals.add(forwardSlash);

        return sumOfDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        // isn't the original line here wrong?
        // return this.square[y][x];
        return this.square[x][y];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        // isn't the original line here wrong?
        // this.square[y][x] = value;
        this.square[x][y] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
