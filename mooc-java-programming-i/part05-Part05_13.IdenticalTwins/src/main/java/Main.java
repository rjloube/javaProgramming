
public class Main {

    public static void main(String[] args) {
        // you can write code here to try out your program
        SimpleDate date = new SimpleDate(24, 3, 2017);
        SimpleDate date2 = new SimpleDate(24, 3, 2017);
        
        Person furio = new Person("furio", date, 50, 10);
        Person furio2 = new Person("furio", date, 50, 10);
        Person furioClone = furio;
        Person pussy = new Person("pussy", date2, 100, 20);
        
        if (furio.equals(pussy)) {
            System.out.println("Sweet");
        }
        System.out.println("pussy");
        
    }
}
