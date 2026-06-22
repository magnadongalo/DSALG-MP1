public final class Prefix {
    public static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9');
    }

    public static boolean isOperand(String s){
        int i;
        boolean res = true;

        for (i=0; i<s.length(); i++)
        {
            if (s.charAt(i) == '-' && i != 0)
                res = false;
            else if (!isOperand(s.charAt(i)) && i != 0)
                res = false;
            else if (s.length() == 1 && !isOperand(s.charAt(i)))
                res = false;
        }
        return res;
    }

    public static boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' ||
                ch == '%' || ch == '^';
    }

    public static boolean isOperator(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") ||
                s.equals("/") || s.equals("%") || s.equals("^");
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

            if (isOperand(ch) || (ch == '-' && isOperand(exp.charAt(i+1))))
            {
                res.append(ch);

                if (i > 0)
                {
                    if (exp.charAt(i-1) == ' ')
                    {
                        res.append(exp.charAt(--i));
                    }
                }
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

        if (res.charAt(res.length() - 1) != ' ')
            res.append(' ');

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
            if (isOperator(splitExp[i]))
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
            else if (isOperand(splitExp[i]))
                st.push(Integer.parseInt(splitExp[i]));
        }
        return st.stackTop();
    }

    public static boolean checkParenthesis(String exp){
        int i, res = 0;

        for (i = 0; i < exp.length(); i++)
        {
            if (exp.charAt(i) == '(')
                res++;
            else if (exp.charAt(i) == ')')
                res--;
        }

        return res == 0;
    }

    public static boolean isProperlySpaced(String exp){
        int i, opCount = 0, spaceCount = 0;
        boolean alternation = true;

        for (i=0; i < exp.length() - 1; i++)
        {
            if (exp.charAt(i) == ' ')
            {
                spaceCount++;

                if (exp.charAt(i+1) == ' ')
                    alternation = false;
            }
            else if (isOperator(exp.charAt(i)) && !isOperand(exp.charAt(i+1)))
            {
                opCount++;

                if (exp.charAt(i+1) != ' ')
                    alternation = false;
            }
        }

        if (spaceCount == 0)
            alternation = false;

        return spaceCount == 2*opCount && alternation;
    }

    public static boolean checkInfix (String exp){
        int i;
        String[] splitExp = exp.split(" ");
        boolean res = true;
        boolean malformed = false;

        for (i=0; i<splitExp.length - 1; i++)
        {
            if (isOperator(splitExp[i]) )
                if (isOperator(splitExp[i+1]))
                {
                    System.out.println("Syntax ERROR: Malformed expression; two operators next to each other!");
                    res = false;
                    malformed = true;
                }
                else if (splitExp[i].equals("/") && splitExp[i+1].equals("0"))
                {
                    System.out.println("Math ERROR: Cannot divide by zero!");
                    res = false;
                }
            else if (isOperand(splitExp[i]))
                if (isOperand(splitExp[i+1]))
                {
                    System.out.println("Syntax ERROR: Malformed expression; two operands next to each other!");
                    res = false;
                    malformed = true;
                }
            else if (!(isOperand(splitExp[i]) || isOperator(splitExp[i])))
            {
                System.out.println("Syntax ERROR: Invalid character!");
                res = false;
            }
        }

        if (!checkParenthesis(exp))
        {
            System.out.println("Syntax ERROR: Mismatched parentheses!");
            res = false;
        }

        if (!isProperlySpaced(exp) && !malformed)
        {
            System.out.println("WARNING: Your expression is not properly spaced!");
            res = false;
        }

        return res;
    }
}