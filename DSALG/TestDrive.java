import java.util.Scanner;

public class TestDrive {
    public static void main(String[] args) {
        //Scanner sc = new Scanner(System.in);
        //String temp;

        //temp = sc.nextLine();

        System.out.println(Prefix.toPrefix("- (1 + 3) * 12"));
        System.out.println(Prefix.evaluatePrefix(Prefix.toPrefix("- (1 + 3) * 12")));
    }
}
