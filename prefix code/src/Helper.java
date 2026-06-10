/**
 * This is a custom class.
 * The static methods in this class help with actions needed across the entire project.
 * - parsing
 * - reversing
 *
 * <p>
 * author @Johann Haree Tolentino
 */


import java.util.ArrayList;

public class Helper {

    // parse function
    public static void parseArray(String str, ArrayList<String> initial)
    {
        // use regex to add each element in str up until
        // it recognized a space, or a symbol into arraylist initial

        int i = 0;
        while (i < str.length())
        {
            char c = str.charAt(i);

            if (Character.isWhitespace(c))
                i++;

            else if (c == '(' || c == ')')
            {
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

                while (i < str.length() && Character.isDigit(str.charAt(i)))
                {
                    builder.append(str.charAt(i));
                    i++;
                }
                initial.add(builder.toString());
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/')
            {
                initial.add(String.valueOf(c));
                i++;
            }
            else
            {
                i++;
            }
        }
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
    }
}
