/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validating;

/**
 *
 * @author rjloube
 */
public class Main {

    public static void main(String[] args) {

        String nullName = null;

        Person person = new Person("shorterThan40", 0);
        System.out.println(person);

        /*
        String nullName = null;
        System.out.println(nullName == null);
        System.out.println(nullName.equals(null));
         */
    }

}
