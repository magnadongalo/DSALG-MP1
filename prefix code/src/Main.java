import java.util.*;

public static void main(String[] args) {
    String input;
    Scanner sc = new Scanner(System.in);

    CustomStack<Integer> integers = new CustomStack<>(100);
    integers.push(1);
    integers.push(2);
    integers.push(3);

    System.out.println(integers.popItem());
    System.out.println(integers.popItem());
    System.out.println(integers.popItem());
}