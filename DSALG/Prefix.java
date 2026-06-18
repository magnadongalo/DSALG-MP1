public final class Prefix {
    public static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9');
    }

    public static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
                ch == '%' || ch == '^';
    }

    public static int precedence(char ch)
    {
        return switch (ch) {
            case '^' -> 3;
            case '*', '/', '%' -> 2;
            case '+', '-' -> 1;
            default -> -1;
        };
    }

    public static char associativity(char ch){
        if (ch == '^')
            return 'R';
        else
            return 'L';
    }

    public static String toPrefix(String exp){
        charStack st = new charStack(exp.length());
        StringBuilder res = new StringBuilder(); //result will be converted back to String
        char ch;
        int i;

        for (i = exp.length() - 1; i >= 0; i--)
        {
            ch = exp.charAt(i);

            if (isOperand(ch))
            {
                res.append(ch);

                if (isOperator(exp.charAt(i-1)))
                {
                    res.append(exp.charAt(i-1));
                    i--;
                }

                if (i > 0)
                    if (!isOperand(exp.charAt(i - 1)))
                        res.append(' ');
            }
            else if (ch == ')')
                st.push(ch);
            else if (ch == '(')
            {
                while (!st.isStackEmpty() && st.stackTop() != ')')
                {
                    res.append(st.pop());
                    res.append(' ');
                }

                if (!st.isStackEmpty())
                    st.pop();
            }
            else if (isOperator(ch))
            {
                while (!st.isStackEmpty() && isOperator(st.stackTop())
                        && precedence(st.stackTop()) > precedence(ch)
                        || precedence(st.stackTop()) == precedence(ch)
                        && associativity(ch) == 'R')
                {
                    res.append(st.pop());
                    res.append(' ');
                }
                st.push(ch);
            }
        }

        while (!st.isStackEmpty())
        {
            res.append(st.pop());
            res.append(' ');
        }

        res.deleteCharAt(res.length() - 1);

        return res.reverse().toString();
    }

    public static int evaluatePrefix(String exp){
        intStack st = new intStack(exp.length());
        String[] splitExp = exp.split(" ");
        int i;
        int num1, num2;

        for (i = splitExp.length - 1; i >= 0; i--)
        {
            if (isOperator(splitExp[i].charAt(0)) && splitExp[i].length() == 1)
            {
                num1 = st.pop();
                num2 = st.pop();
                switch (splitExp[i].charAt(0))
                {
                case '+':
                    st.push(num1 + num2);
                    break;
                case '-':
                    st.push(num1 - num2);
                    break;
                case '*':
                    st.push(num1 * num2);
                    break;
                case '/':
                    st.push(num1 / num2);
                    break;
                case '%':
                    st.push(num1 % num2);
                    break;
                case '^':
                    st.push(num1 ^ num2);
                    break;
                }
            }
            else if (isOperand(splitExp[i].charAt(0)) ||
                    (isOperator(splitExp[i].charAt(0)) && splitExp[i].length() != 1))
                st.push(Integer.parseInt(splitExp[i]));
        }
        return st.stackTop();
    }

    public static boolean checkParentheses (String exp){
        int i, sum=0;

        for (i=0; i<exp.length(); i++)
        {
            if (exp.charAt(i) == '(')
                sum++;
            else if (exp.charAt(i) == ')')
                sum--;
        }
        return sum == 0;
    }
    public static boolean checkInfix (String exp){
        int i;
        String[] splitExp = exp.split(" ");
        boolean res = true;

        for (i=0; i<splitExp.length - 1; i++)
        {
            if (isOperator(splitExp[i].charAt(0)) && splitExp[i].length() == 1)
                if (isOperator(splitExp[i+1].charAt(0)) && splitExp[i+1].length() == 1)
                {
                    System.out.println("Error: Malformed expression; two operators next to each other!");
                    res = false;
                }
                else if (splitExp[i].charAt(0) == '/' && splitExp[i+1].equals("0"))
                {
                    System.out.println("Error: Cannot divide by zero!");
                    res = false;
                }
            else if (isOperand(splitExp[i].charAt(0)) ||
                    (isOperator(splitExp[i].charAt(0)) && splitExp[i].length() != 1))
                if (isOperand(splitExp[i+1].charAt(0)) ||
                    (isOperator(splitExp[i+1].charAt(0)) && splitExp[i+1].length() != 1))
                {
                    System.out.println("Error: Malformed expression; two operands next to each other!");
                    res = false;
                }
            else if (splitExp[i].length() == 1 &&
                    (!isOperator(splitExp[i].charAt(0)) || !isOperand(splitExp[i].charAt(0))))
                {
                    System.out.println("Error: Invalid character!");
                    res = false;
                }
        }

        if (!checkParentheses(exp))
        {
            System.out.println("Error: Mismatched parentheses!");
            res = false;
        }
        return res;
    }
}
