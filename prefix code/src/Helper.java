/*
 * This is a custom written helper class.
 *
 * The static methods in this class help with actions needed across the entire project.
 * - parsing
 * - reversing
 *
 * <p>
 * author @Johann Haree Tolentino
 */


import java.util.ArrayList;

public class Helper {

    /*
    The parse function

    Locate this function's else bracket containing a mere valid = false; and i++. idk but my theory suggests that
    this is for invalid character checking
     */

    /**
     * parseArray() returns an arraylist containing all elements of an inputted string equation separated by spaces.
     * Method has built in checkers for many invalid cases determined by parsing type
     *
     * @param str the string to be parsed and converted into an arraylist
     * @param parsingType 1 if parsing for infix to prefix, 0 if parsing for prefix to infix
     * @return ArrayList containing strings of each element separated by space
     */
    public static ArrayList<String> parseArray(String str, int parsingType)
    {
        int i = 0;
        int errorCode = 0;
        int parenCache = 0;
        boolean valid = true;
        char invalid = 0;
        ArrayList<String> initial = new ArrayList<>();
        boolean expectOperator = false;

        while (i < str.length() && valid)
        {
            char c = str.charAt(i);

            if (Character.isWhitespace(c))
            {
                i++;
            }
            else if (c == '(')
            {
                parenCache++;
                initial.add(String.valueOf(c));
                i++;
                expectOperator = false; // operand or another '(' next
            }
            else if (c == ')')
            {
                parenCache--;
                if (parenCache < 0)
                {
                    errorCode = 2;
                    valid = false;
                }
                initial.add(String.valueOf(c));
                i++;
                expectOperator = true; // operator or another ')' next
            }

            // Digit Parsing (Handles positive/negative numbers)
            else if (Character.isDigit(c) ||
                    ((c == '-' || c == '+') && i + 1 < str.length() && Character.isDigit(str.charAt(i + 1))))
            {
                StringBuilder builder = new StringBuilder();

                if (c == '-') {
                    builder.append('-');
                    i++;
                } else if (c == '+') {
                    i++;
                }

                while (i < str.length() && Character.isDigit(str.charAt(i)))
                {
                    builder.append(str.charAt(i));
                    i++;
                }

                String numStr = builder.toString();

                // Zero division check for type 1
                if (numStr.equals("0") && parsingType == 1)
                {
                    if (!initial.isEmpty() && initial.getLast().equals("/"))
                    {
                        errorCode = 3;
                        valid = false;
                    }
                }

                initial.add(numStr);
                expectOperator = true; // operator should follow
            }
            // Variable/Letter Parsing
            else if (Character.isLetter(c) ||
                    ((c == '-' || c == '+') && i + 1 < str.length() && Character.isLetter(str.charAt(i + 1))))
            {
                StringBuilder builder = new StringBuilder();

                if (c == '-') {
                    builder.append('-');
                    i++;
                } else if (c == '+') {
                    i++;
                }

                while (i < str.length() && Character.isLetter(str.charAt(i)))
                {
                    builder.append(str.charAt(i));
                    i++;
                }

                initial.add(builder.toString());
                expectOperator = true; // operator should follow
            }
            // Operator Parsing
            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == '%')
            {
                // Malformed expression check using the boolean state
                if (parsingType == 1 && !expectOperator)
                {
                    errorCode = 4;
                    invalid = c;
                    valid = false;
                }

                initial.add(String.valueOf(c));
                i++;
                expectOperator = false; // operand should follow
            }
            else
            {
                errorCode = 5;
                invalid = c;
                valid = false;
                i++;
            }
        }

        if (valid && parenCache != 0)
        {
            errorCode = 1;
            valid = false;
        }

        ArrayList<String> finalResult = new ArrayList<>();

        if (valid) finalResult = initial;
        else
        {
            System.out.println("error code: " + errorCode);
            String codeDescription = switch (errorCode) {
                case 1 -> "MismatchedInput: One or more '(' instances were left unclosed.";
                case 2 -> "MismatchedInput: You are trying to input a ')' while a '(' instance is not present.";
                case 3 -> "ZeroNonDivisible: Cannot divide by 0.";
                case 4 -> "MalformedExpression: Consecutive operator '" + invalid + "' found where an operand was expected.";
                case 5 -> "InvalidInput: '" + invalid + "' is an invalid symbol and cannot be parsed.";
                default -> "";
            };
            System.out.println(codeDescription);
            finalResult = null;
        }

        return finalResult;
    }

    // reverse function
    // Doomscrolling lead me to this reverse solution

    /**
     * reverseArray reverses the order of an inputted String ArrayList
     * @param array String ArrayList to reverse
     */
    public static void reverseArray(ArrayList<String> array)
    {
        int left = 0;
        int right = array.size() - 1;

        while (left < right)
        {
            String temp = array.get(left);

            // this is essentially array[left] = array[right]
            array.set(left, array.get(right));
            array.set(right, temp);

            left++;
            right--;
        }

        // this function also reverses the parenthesis
        // switchParenthesis() should switch the parenthesis back for proper formatting
        switchParenthesis(array);
    }

    /**
     * switchParenthesis locates all open and close parenthesis and switches them for correct reverse formatting
     * @param array String ArrayList to switch parenthesis
     */
    public static void switchParenthesis(ArrayList<String> array)
    {
        int i = 0;
        while (i < array.size()) {
            switch (array.get(i))
            {
                case "(":
                    array.set(i, ")");
                    break;
                case ")":
                    array.set(i, "(");
                    break;
            }
            i++;
        }
    }

    /**
     * isOperand checks if an inputted string is an operand of an expression
     * @param str the string to check
     * @return true if str is operand, false if otherwise
     */
    public static boolean isOperand(String str) {
        boolean result = false;

        if (str != null && !str.isEmpty()) {
            if (str.matches("(-?\\d+(\\.\\d+)?|[a-zA-Z]+)"))
            {
                result = true;
            }
        }
        return result;
    }

    /**
     * isLetter checks if an inputted string is a letter
     * @param str the string to check
     * @return true if str is a letter, false if otherwise
     */
    public static boolean isLetter(String str) {
        boolean result = false;

        if (str != null && !str.isEmpty()) {
            if (str.matches(".*[a-zA-Z].*")) {
                result = true;
            }
        }

        return result;
    }

    /**
     * isOperator checks if an inputted string is an operator (symbol) [+, -, *, /, %, ^] of an expression
     * @param str the string to check
     * @return true if str is an operator, false if otherwise
     */
    public static boolean isOperator(String str) {
        boolean result = false;

        if (str != null && !str.isEmpty())
        {
            if (str.matches("^[()+\\-*/^%\\s]+$"))
            {
                result = true;
            }
        }

        return result;
    }

    /**
     * stringRebuilder builds a string based on the elements of a String ArrayList
     * @param array the String ArrayList to build a string out of
     * @param type 1 or more if building an infix statement, 0 or less if building a prefix statement
     * @return complete string with spaces (formatting)
     */
    public static String stringRebuilder(ArrayList<String> array, int type)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < array.size(); i++) {
            String s = array.get(i);
            stringBuilder.append(s);

            if (type >= 1)
            {
                boolean nextClosing = (i + 1 < array.size()) && array.get(i + 1).equals(")");

                if (!s.equals("(") && !nextClosing)
                {
                    stringBuilder.append(" ");
                }
            }
        }

        return stringBuilder.toString().trim();
    }

    /**
     * checkPrecedence returns an int representing the precedence of an operand
     * @param str the operand to be determined a precedence
     * @return precedence value
     */
    public static int checkPrecedence(String str)
    {
        return switch (str) {
            case "(", ")" -> 4;
            case "^"      -> 3;
            case "*", "/", "%" -> 2;
            case "+", "-" -> 1;
            default       -> -1;
        };
    }

    /**
     * toExpression takes in a left string, a right string, and an operand string to build an expression
     * @param str1 right value of the expression
     * @param str2 left value of the expression
     * @param symbol the operand to be placed in between
     * @return String of the combined expression
     */
    public static String toExpression(String str1, String str2, String symbol)
    {
        return str2 + " " + symbol + " " + str1;
    }

    /**
     * calculateStuff contains generic math computations recognizing a left and right of an expression, calculated by
     * an operand string
     * @param left left side of an expression
     * @param right right side of an expression
     * @param symbol the operand to be used for computing result
     * @return calculated result
     */
    public static String calculateStuff(int left, int right, String symbol)
    {
        int result = switch (symbol) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            case "/" -> left / right;
            case "%" -> left % right;
            case "^" -> (int) Math.pow(left, right);
            default -> 0;
        };

        return String.valueOf(result);
    }
}
