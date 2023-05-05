
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here

        // set the top center position to 1
        int x = 0; // top row
        int y = ((square.getWidth() + 1) / 2) - 1; // index for median of top row
        square.placeValue(x, y, 1);
        
        for (int i = 2; i <= square.getHeight() * square.getWidth(); i++) {
            int newX = x;
            if (x - 1 < 0) {
                newX = square.getHeight() - 1;
            } else {
                newX--;
            }
            
            int newY = y;
            if (y + 1 > square.getWidth() - 1) {
                newY = 0;
            } else {
                newY++;
            }
            
            if (square.readValue(newX, newY) == 0) {
                x = newX;
                y = newY;
                square.placeValue(x, y, i);
            } else {
                x++;
                square.placeValue(x, y, i);
            }
            // System.out.println("x: " + x + ", y: " + y);
        }
        
        return square;
    }

}
