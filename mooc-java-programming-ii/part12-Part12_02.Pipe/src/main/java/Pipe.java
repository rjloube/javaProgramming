
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
public class Pipe<T> {
    
    private ArrayList<T> values;
    
    public Pipe() {
        this.values = new ArrayList<>();
    }
    
    public void putIntoPipe(T value) {
        this.values.add(value);
    }
    
    public T takeFromPipe() {
        if (this.values.isEmpty()) {
            return null;
        } else {
            T lastValue = this.values.get(0);
            this.values.remove(0);
            return lastValue;
        }
    }
    
    public boolean isInPipe() {
        if (this.values.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
    
}
