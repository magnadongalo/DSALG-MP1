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

            if (Helper.isNumber(temp))
            {
                result.add(temp);
                result.add(" ");
            }
            else if (Helper.isSymbol(temp))
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
                else if (checkPrecedence(temp) > 0)
                {
                    while (!tempStack.isEmpty() && !tempStack.top().equals("(") && checkPrecedence(tempStack.top()) > checkPrecedence(temp))
                    {
                        result.add(tempStack.popItem());
                        result.add(" ");
                    }
                    tempStack.push(temp);
                }
            }
        }

        while  (!tempStack.isEmpty())
        {
            result.add(tempStack.popItem());
            result.add(" ");
        }

        // reverse result
        Helper.reverseArray(result);

        // return final string
        return Helper.stringRebuilder(result);
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

    // precedence checking function
    private static int checkPrecedence(String str)
    {
        return switch (str) {
            case "(", ")" -> 4;
            case "^"      -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default       -> -1;
        };
    }

    // combine final string function
}

//while (i < initial.size())
//        {
//String temp = initial.get(i);
//
//            if (Helper.isNumber(temp))
//        {
//        result.add(temp);
//            }
//                    else if (Helper.isSymbol(temp))
//        {
//        // check top of stack if a symbol is present
//        // push depending on precedence
//        // add to result depending on precedence
//        // pop all if parenthesis match
//        if (tempStack.top() != null)
//        {
//// 1 = element in stack is higher
//// 2 = element in stack is lower
//// 3 = element in stack is an end parenthesis
//int precedence = 0;
//                    switch (precedence)
//        {
//        case 1:
//        tempStack.push(temp);
//                            break;
//                                    case 2:
//                                    result.add(tempStack.popItem());
//        break;
//        case 3:
//        break;
//        }
//        }
//        else
//        {
//        tempStack.push(temp);
//                }
//                        }
//i++;
//        }
//
//        // invert final string array via calling the function
//        Helper.reverseArray(result);
