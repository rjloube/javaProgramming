
public class AdvancedAstrology {

    public static void printStars(int number) {
        for (int stars = 1; stars <= number; stars++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void printSpaces(int number) {
        for (int spaces = 1; spaces <= number; spaces++) {
            System.out.print(" ");
        }
    }

    public static void printTriangle(int size) {
        for (int triangles = 1; triangles <= size; triangles++) {
            printSpaces(size - triangles);
            printStars(triangles);
            
        }
    }

    public static void christmasTree(int height) {
        int stars = 1;
        for (int rows = 1; rows <= height; rows++) {
            printSpaces(height - rows);
            printStars(stars);
            stars += 2;
        }
        for (int rows = 1; rows <= 2; rows++) {
            printSpaces(height - 2);
            printStars(3);
        }
    }

    public static void main(String[] args) {
        // The tests are not checking the main, so you can modify it freely.

        printTriangle(4);
        System.out.println("---");
        christmasTree(4);
        System.out.println("---");
        christmasTree(10);
    }
}
