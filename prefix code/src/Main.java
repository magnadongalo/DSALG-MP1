import java.util.*;

public static void main(String[] args) {
//    String input;
//    Scanner sc = new Scanner(System.in);
//
//    CustomStack<Integer> integers = new CustomStack<>(100);
//    integers.push(1);
//    integers.push(2);
//    integers.push(3);
//
//    System.out.println(integers.popItem());
//    System.out.println(integers.popItem());
//    System.out.println(integers.popItem());

//    ArrayList<String> list = new ArrayList<>();
//    String str = "(1 + 2^3) + 3 * (4 - 5)";
//
//    Helper.parseArray(str, list);
//    Helper.reverseArray(list);
//
//    System.out.println(list);

    String input = "3 + 4 * (2^5 - 1)";
    String input2 = "(1 + 2^3) + Minecraft * (4 - 5)";

    String input3 = "+ + 1 2 * 3 - 4 5";

    String prefixOutput = Prefix.convertToPrefix(input);
    String prefixOutput2 = Prefix.convertToPrefix(input2);

    String prefixOutput3 = Prefix.convertToInfix(input3);

//    System.out.println(prefixOutput);
    System.out.println(prefixOutput2);
//    System.out.println(prefixOutput3);
}