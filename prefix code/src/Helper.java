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
     * parseArray returns an arraylist containing all elements of an inputted string equation separated by spaces
     *
     * @param str the string to be parsed and converted into an arraylist
     * @param type 1 if parsing for infix to prefix, 0 if parsing for prefix to infix
     * @return ArrayList containing strings of each element separated by space
     */
    public static ArrayList<String> parseArray(String str, int type)
    {
        // use regex to add each element in str up until
        // it recognized a space, or a symbol into arraylist initial

        int i = 0;

        boolean frontCache =  false;
        boolean valid = true;

        char previous = 0;

        ArrayList<String> initial = new ArrayList<>();

        while (i < str.length() && valid)
        {
            char c = str.charAt(i);

            if (Character.isWhitespace(c))
                i++;

            else if (c == '(')
            {
                if (frontCache) valid = false;
                else frontCache = true;

                initial.add(String.valueOf(c));
                i++;
            }

            else if (c == ')')
            {
                frontCache = false;

                initial.add(String.valueOf(c));
                i++;
            }

            else if(Character.isDigit(c) ||
                    ((c == '-' || c == '+') && Character.isDigit(str.charAt(i + 1))))
            {
                StringBuilder builder = new StringBuilder();

                if (c == '-')
                {
                    builder.append('-');
                    i++;
                }
                else if (c == '+')
                {
                    i++;
                }

                // previous only gets affected when parsing operators
                // straightforward zero checking when previous is '/'
                // make sure this checks only when its type 1 (infix to prefix parsing)
                if (c == '0' && previous == '/' && type == 1)
                {
                    valid = false;
                }

                while (i < str.length() && Character.isDigit(str.charAt(i)))
                {
                    builder.append(str.charAt(i));
                    i++;
                }
                initial.add(builder.toString());
            }

            else if(Character.isLetter(c) ||
                    ((c == '-' || c == '+') && Character.isLetter(str.charAt(i + 1))))
            {
                StringBuilder builder = new StringBuilder();

                if (c == '-')
                {
                    builder.append('-');
                    i++;
                }
                else if (c == '+')
                {
                    i++;
                }

                while (i < str.length() && Character.isLetter(str.charAt(i)))
                {
                    builder.append(str.charAt(i));
                    i++;
                }
                initial.add(builder.toString());
            }

            else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^')
            {
                if (isMalformed(previous)) valid = false;

                initial.add(String.valueOf(c));
                i++;

                previous = c;
            }
            else // is this like invalid characters
            {
                // valid = false;

                i++;
            }
        }

        // returns null if valid is false
        // checking is hard coded into this solution
        if (valid) return initial;
        else return null;
    }

    // reverse function
    // Doomscrolling lead me to this reverse solution
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

    public static boolean isOperand(String str) {
        if (str == null || str.isEmpty())
        {
            return false;
        }

        return str.matches("(-?\\d+(\\.\\d+)?|[a-zA-Z]+)");
    }

    public static String stringRebuilder(ArrayList<String> array, int type)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (String s : array) {
            stringBuilder.append(s);

            if (type >= 1)
            {
                stringBuilder.append(" ");
            }
        }

        return stringBuilder.toString().trim();
    }

    public static int checkPrecedence(String str)
    {
        return switch (str) {
            case "(", ")" -> 4;
            case "^"      -> 3;
            case "*", "/" -> 2;
            case "+", "-" -> 1;
            default       -> -1;
        };
    }

    public static String toExpression(String str1, String str2, String symbol)
    {
        return str2 + " " + symbol + " " + str1;
    }

    public static boolean checkExpression(String str1, String str2, String symbol)
    {
        return !str2.equals("0") || !symbol.equals("/");
    }

    public static boolean isMalformed(char compare)
    {
        return compare == '+' ||
                compare == '-' ||
                compare == '*' ||
                compare == '/' ||
                compare == '^';
    }

    public static boolean isOperator(String str) {
        if (str == null || str.isEmpty())
        {
            return false;
        }

        return str.matches("^[()+\\-*/^\\s]+$");
    }
}
