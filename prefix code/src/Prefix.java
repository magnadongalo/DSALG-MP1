import java.util.ArrayList;
import java.util.Collections;

public class Prefix {

    public static String convertToPrefix(String str)
    {
        // initial string array needed
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        // add the parser
        Helper.parseArray(str, initial);

        // reverse the string array
        Helper.reverseArray(initial);

        // queue needed
        // stack needed
        // result string array needed
        CustomQueue<String> tempQueue = new CustomQueue<>(100);
        CustomStack<String> tempStack = new CustomStack<>(100);
        ArrayList<String> result = new ArrayList<>();

        // compute precedence
            // add to queue if number
            // add to stack if symbol
                // check next symbol
                    // if next is higher, add to stack
                    // if next is lower, keep pushing to queue



        // invert final string array via calling the function
        Helper.reverseArray(result);

        // return final string
        return "result";
    }

    public static String convertToInfix(String str)
    {
        // initial string array needed
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        // add the parser
        Helper.parseArray(str, initial);

        // reverse the string array
        Helper.reverseArray(initial);

        // queue needed?
        // stack needed
        // result string array needed
        // CustomQueue<String> tempQueue = new CustomQueue<>(100);
        CustomStack<String> tempStack = new CustomStack<>(100);
        ArrayList<String> result = new ArrayList<>();

        // input 1st number into stack
        // input 2nd number into stack
        // Recognize operator

        // Recognize 2 numbers in stack
            // Right operand is 2nd number
            // Left operand is 1st number
        // Compute expression, then insert back into stack as one element
        // only get the last 2 operands when computing for final expression
        // Add parenthesis based to 1st expression (if an expression string) based on next operand

        // Repeat until end

        // Reverse string again

        // Return final string
        return "finished";
    }

    // compare per string in array function

    // precedence checking function

    // combine final string function
}
