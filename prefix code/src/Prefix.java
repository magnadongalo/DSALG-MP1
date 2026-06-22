import java.util.ArrayList;
import java.util.Collections;

public class Prefix {

    /**
     * convertToPrefix converts an inputted infix expression into an prefix expression
     * @param str the infix expression to be converted
     * @return String converted prefix expression
     */
    public static String convertToPrefix(String str)
    {
        // initial string array needed
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        // add the parser
        initial = Helper.parseArray(str, 1);

        String finalResult = "";

        // reverse the string array
        // returns invalid input when something is wrong
        if (initial != null)
        {
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
            finalResult = Helper.stringRebuilder(result, 0);
        }
        else
        {
            finalResult = "Invalid Input";
        }

        return finalResult;
    }

    /**
     * convertToInfix converts an inputted prefix expression into an infix expression
     * @param str the prefix expression to be converted
     * @return String converted infix expression
     */
    public static String convertToInfix(String str)
    {
        // initial string array needed
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        // add the parser
        initial = Helper.parseArray(str, 0);

        String finalResult = "";

        // reverse the string array
        if (initial != null)
        {
            Helper.reverseArray(initial);

            // stack needed
            // operator stack to track current operators
            CustomStack<String> tempStack = new CustomStack<>(100);
            CustomStack<String> operatorStack = new CustomStack<>(100);

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

                if (Helper.isOperand(temp)) {
                    tempStack.push(temp);
                    // push none if scanned is not an operator
                    operatorStack.push("NONE");
                } else if (Helper.isOperator(temp)) {
                    String left = tempStack.popItem();
                    String right = tempStack.popItem();

                    // pop operators on both sides of expression then assign to string
                    String leftOperator = operatorStack.popItem();
                    String rightOperator = operatorStack.popItem();

                    // Check precedence of left main, and current operator
                    // if it's less than, add parenthesis
                    if (!leftOperator.equals("NONE") && Helper.checkPrecedence(leftOperator) < Helper.checkPrecedence(temp)) {
                        left = "(" + left + ")";
                    }

                    // Check precedence of temp, and right main operator
                    // if it's less than, add parenthesis
                    if (!rightOperator.equals("NONE") && Helper.checkPrecedence(rightOperator) < Helper.checkPrecedence(temp)) {
                        right = "(" + right + ")";
                    }

                    // Edge case
                    // Addition and multiplication are associative, minus and divide do not
                    // This handles it
                    if (!rightOperator.equals("NONE") && Helper.checkPrecedence(rightOperator) == Helper.checkPrecedence(temp)) {
                        if (temp.equals("-") || temp.equals("/") || temp.equals("%")) {
                            right = "(" + right + ")";
                        }
                    }

                    // combine formatted expression
                    String expression = Helper.toExpression(left, right, temp);

                    tempStack.push(expression);
                    operatorStack.push(temp); // main operator
                }
            }
            // Repeat until end

            ArrayList<String> result;
            result = Helper.parseArray(tempStack.popItem(), 0);

            if (result != null)
            {
                Helper.reverseArray(result);
                finalResult = Helper.stringRebuilder(result, 1);
            }
            else
            {
                finalResult = "Invalid Input";
            }
        }
        else
        {
            finalResult = "Invalid Input";
        }

        return finalResult;
    }

    /**
     * evaluate evaluates the result of a prefix expression
     * @param str the prefix expression to be evaluated
     * @return int - result of evaluation
     */
    public static int evaluate(String str)
    {
        ArrayList<String> initial = new ArrayList<>();
        Collections.fill(initial, "");

        initial = Helper.parseArray(str, 0);

        boolean letterBound = Helper.isLetter(str);

        int finalResult = 0;

        if (initial != null && !letterBound && !str.isEmpty())
        {
            Helper.reverseArray(initial);

            CustomStack<String> tempStack = new CustomStack<>(100);

            int i;
            for (i = 0; i < initial.size(); i++)
            {
                String temp = initial.get(i);

                if (Helper.isOperand(temp)) {
                    tempStack.push(temp);
                }
                else if (Helper.isOperator(temp))
                {
                    // singular unary operator handling
                    if (temp.equals("-") && i == initial.size() - 1)
                    {
                        String left = "-" + tempStack.popItem();
                        tempStack.push(left);
                    }
                    else
                    {
                        int left = Integer.parseInt(tempStack.popItem());
                        int right = Integer.parseInt(tempStack.popItem());

                        tempStack.push(Helper.calculateStuff(left, right, temp));
                    }
                }
            }

            finalResult = Integer.parseInt(tempStack.popItem());
        }

        if (letterBound)
        {
            System.out.println("LetterCalculationException: Non-integer operands cannot be calculated.");
            finalResult = 33550336;
        }

        return finalResult;
    }
}