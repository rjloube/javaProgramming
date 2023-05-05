
public class Apartment {

    private int rooms;
    private int squares;
    private int pricePerSquare;

    public Apartment(int rooms, int squares, int pricePerSquare) {
        this.rooms = rooms;
        this.squares = squares;
        this.pricePerSquare = pricePerSquare;
    }

    public boolean largerThan(Apartment compared) {
        return this.squares > compared.squares;
    }

    public int priceDifference(Apartment compared) {
        int calculation = (this.squares * this.pricePerSquare) - (compared.squares * compared.pricePerSquare);
        if (calculation > 0) {
            return calculation;
        } else {
            return calculation * -1;
        }
    }

    public boolean moreExpensiveThan(Apartment compared) {
        return this.squares * this.pricePerSquare > compared.squares * compared.pricePerSquare;
    }
}
