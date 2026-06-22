/*
sum random driver script for testing shit out
 */

public class Main {
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

//        String input = "1 - 0 + (20287278328907)";
//        String input2 = "(1 + 2^3) + Minecraft * (4 % 5)";
//        String input3 = "((5 + 3) * 2) ^ (1 + 1)";
//
//        String input4 = "+ + 1 2 * 3 - 4 5";
//        String input5 = "/ + CallOfDuty BlocksBurg + LegendsOfZelda Roblox";
//        String input6 = "+ * H * * * + A * - B C D F E G J";
//
//        String matchedPrefix = "+ + 1 2 * 3 - 4 5";
//        String matchedInfix = "1 + 2 + 3 * (4 - 5)";
//
//        String prefixOutput = Prefix.convertToPrefix(input);
//        String prefixOutput2 = Prefix.convertToPrefix(input2);
//        String prefixOutput3 = Prefix.convertToPrefix(input3);
//
//        String prefixOutput4 = Prefix.convertToInfix(input4);
//        String prefixOutput5 = Prefix.convertToInfix(input5);
//        String prefixOutput6 = Prefix.convertToInfix(input6);
//
//        String fahh = Prefix.convertToInfix(matchedPrefix);
//        String fahh2 = Prefix.convertToPrefix(matchedInfix);
//
//        System.out.println(prefixOutput);
//        System.out.println(prefixOutput2);
//        System.out.println(prefixOutput3);
//        System.out.println(prefixOutput4);
//        System.out.println(prefixOutput5);
//        System.out.println(prefixOutput6);
//        System.out.println(fahh);
//        System.out.println(fahh2);

//        String infix = "+ - * 5 2";
//
//        String eval = Prefix.convertToPrefix(infix);
//        System.out.println(eval);

        String infix = "+ - * 5 2";
        int eval = Prefix.evaluate(infix);

        System.out.println(eval);
    }
}