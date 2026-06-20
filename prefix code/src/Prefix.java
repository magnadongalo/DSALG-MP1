import java.util.ArrayList;
import java.util.Collections;

public class Prefix {

    public static String convertToPrefix(String str)
    {
        // initial string array needed
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        // add the parser
        initial = Helper.parseArray(str, 1);

        // reverse the string array
        // returns invalid input when something is wrong
        if (initial != null) Helper.reverseArray(initial);
        else return "Invalid Input";

        // queue needed
        // stack needed
        // result string array needed
        // CustomQueue<String> tempQueue = new CustomQueue<>(100);
        CustomStack<String> tempStack = new CustomStack<>(100);
        ArrayList<String> result = new ArrayList<>();

        // compute precedence
            // add to queue if number
            // add to stack if symbol
                // check next symbol
                    // if next is higher, add to stack
                    // if next is lower, keep pushing to queue

        int i;
        for (i = 0; i < initial.size(); i++)
        {
            String temp = initial.get(i);

            if (Helper.isOperand(temp))
            {
                result.add(temp);
                result.add(" ");
            }
            else if (Helper.isOperator(temp))
            {
                if (temp.equals("("))
                {
                    tempStack.push(temp);
                }
                else if (temp.equals(")"))
                {
                    while (!tempStack.isEmpty() && !tempStack.top().equals("("))
                    {
                        result.add(tempStack.popItem());
                        result.add(" ");
                    }
                    tempStack.pop();
                }
                else if (Helper.checkPrecedence(temp) > 0)
                {
                    while (!tempStack.isEmpty() &&
                            !tempStack.top().equals("(") &&
                            Helper.checkPrecedence(tempStack.top()) > Helper.checkPrecedence(temp))
                    {
                        result.add(tempStack.popItem());
                        result.add(" ");
                    }
                    tempStack.push(temp);
                }
            }
        }

        while (!tempStack.isEmpty())
        {
            result.add(tempStack.popItem());
            result.add(" ");
        }

        // reverse result
        Helper.reverseArray(result);

        // return final string
        return Helper.stringRebuilder(result, 0);
    }

    public static String convertToInfix(String str)
    {
        // initial string array needed
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        // add the parser
        initial = Helper.parseArray(str, 0);

        // reverse the string array
        if (initial != null) Helper.reverseArray(initial);
        else return "Invalid Input";

        // stack needed
        CustomStack<String> tempStack = new CustomStack<>(100);
        // ArrayList<String> result = new ArrayList<>();

        // Helper.reverseArray(result);
        // input 1st number into stack
        // input 2nd number into stack
        // Recognize operator

        // Recognize 2 expressions in stack
        // Right operand is 2nd expression
        // Left operand is 1st expression
        // Compute expression, then insert back into stack as one element
        // only get the last 2 operands when computing for final expression
        // Add parenthesis based to 1st expression (if an expression string) based on next operand
        int i;
        for (i = 0; i < initial.size(); i++) {
            String temp = initial.get(i);

            if (Helper.isOperand(temp))
            {
                tempStack.push(temp);
            }
            else if (Helper.isOperator(temp))
            {
                String right = tempStack.popItem();
                String left = tempStack.popItem();

                String expression = Helper.toExpression(left, right, temp);
                tempStack.push(expression);

                // unnecessary parenthesis checking here
            }
        }
        // Repeat until end

        // Return final string
        return tempStack.popItem();
    }
}