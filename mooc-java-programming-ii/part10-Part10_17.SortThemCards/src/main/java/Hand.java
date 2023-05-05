
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rjloube
 */
public class Hand implements Comparable<Hand> {

    private ArrayList<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void add(Card card) {
        this.cards.add(card);
    }

    public void print() {
        this.cards.stream().forEach(card -> {
            System.out.println(card);
        });
    }

    public void sort() {
        Collections.sort(cards);
    }

    public ArrayList<Card> getCards() {
        return this.cards;
    }

    @Override
    public int compareTo(Hand hand) {

        int thisSum = 0;

        for (Card card : this.cards) {
            thisSum += card.getValue();
        }

        int handSum = 0;

        for (Card card : hand.getCards()) {
            handSum += card.getValue();
        }

        if (thisSum == handSum) {
            return 0;
        } else if (thisSum > handSum) {
            return 1;
        } else {
            return -1;
        }
    }

    public void sortBySuit() {
        BySuitInValueOrder sortBySuitInValueSorter = new BySuitInValueOrder();
        Collections.sort(this.cards, sortBySuitInValueSorter);
    }

}
