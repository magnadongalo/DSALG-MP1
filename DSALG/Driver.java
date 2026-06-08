import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String temp = Prefix.toPrefix("(1 + 2) * 3");

        System.out.println(temp);

        System.out.println(Prefix.evaluatePrefix(Prefix.toPrefix("(1 + 2) * 3")));
    }
}
