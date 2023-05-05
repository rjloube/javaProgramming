
public class Checker {

    public boolean isDayOfWeek(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean allVowels(String string) {
        if (string.matches("[aeiou]*")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean timeOfDay(String string) {
        if (string.matches("(([0-1]{1}[0-9]{1})|(2{1}[0-3]{1}))"
                + ":[0-5]{1}[0-9]{1}"
                + ":[0-5]{1}[0-9]{1}")) {
            return true;
        } else {
            return false;
        }
    }

}
