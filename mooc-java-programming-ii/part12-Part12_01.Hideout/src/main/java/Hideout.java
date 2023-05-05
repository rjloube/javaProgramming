/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rjloube
 */
public class Hideout<T> {

    private T element;

    public void putIntoHideout(T toHide) {
        this.element = toHide;
    }

    public T takeFromHideout() {
        if (this.element == null) {
            return null;
        } else {
            T helper = this.element;
            this.element = null;
            return helper;
        }
    }

    public boolean isInHideout() {
        if (this.element == null) {
            return false;
        } else {
            return true;
        }
    }

}
