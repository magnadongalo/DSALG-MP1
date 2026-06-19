import java.sql.SQLOutput;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        System.out.println(Prefix.toPrefix("(10 - -20) * 30"));

        System.out.println(Prefix.evaluatePrefix(Prefix.toPrefix("(10 - -20) * 30")));

        System.out.println(Prefix.checkInfix("(12 / 0) + 12 3"));
    }
}
