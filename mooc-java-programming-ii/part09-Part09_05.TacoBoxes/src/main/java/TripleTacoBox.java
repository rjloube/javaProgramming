/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjloube
 */
public class TripleTacoBox implements TacoBox {
    
    private int tacos;
    
    public TripleTacoBox() {
        this.tacos = 3;
    }
    
    @Override
    public int tacosRemaining() {
        return this.tacos;
    }
    
    @Override
    public void eat() {
        if (this.tacos > 0) {
            this.tacos--;
        }
    }
    
}
