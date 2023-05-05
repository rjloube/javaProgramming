/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjloube
 */
public class Timer {

    private ClockHand centiseconds;
    private ClockHand seconds;

    public Timer() {
        this.centiseconds = new ClockHand(100);
        this.seconds = new ClockHand(60);
    }

    public String toString() {
        return this.seconds + ":" + this.centiseconds;
    }

    public void advance() {
        this.centiseconds.advance();
        
        if (this.centiseconds.value() == 0) {
            this.seconds.advance();
        }
    }

}
