
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rjloube
 */
public class Herd implements Movable {

    private ArrayList<Movable> members;

    public Herd() {
        this.members = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        this.members.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable member : members) {
            member.move(dx, dy);
        }
    }

    @Override
    public String toString() {

        String output = "";

        for (Movable member : this.members) {
            output += member.toString() + "\n";
        }

        return output;
    }

}
