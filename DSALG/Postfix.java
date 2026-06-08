public final class Postfix{
    public static boolean isOperand(char ch){
        return (ch >= 'A' && ch <= 'Z')
                || (ch >= 'a' && ch <= 'z')
                || (ch >= '0' && ch <= '9');
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

    public static boolean operatorPrecedenceCondition(String infix, int i, charStack S){
        return precedence(infix.charAt(i)) < precedence(S.stackTop()) ||
                precedence(infix.charAt(i)) == precedence(S.stackTop()) &&
                associativity(infix.charAt(i)) == 'L';

    }

    public static String toPostfix(String exp){
        charStack ops = new charStack(exp.length()); //stack of operations
        StringBuilder res = new StringBuilder(); //result will be converted back to String
        char ch;
        int i;

        for (i=0; i<exp.length(); i++)
        {
            ch = exp.charAt(i);

            if (isOperand(ch))
            {
                res.append(ch);

                if (i+1<exp.length())
                    if (!isOperand(exp.charAt(i+1)))
                        res.append(' ');

                if (i+1 == exp.length())
                    res.append(' ');
            }
            else if (ch == '(')
            {
                ops.push(ch);
            }
            else if (ch == ')')
            {
                while (ops.stackTop() != '(' && operatorPrecedenceCondition(exp, i, ops))
                {
                    res.append(ops.pop());
                    res.append(' ');
                }
                ops.pop(); //remove parenthesis
            }
            else if (ch != ' ')
            {
                while (!ops.isStackEmpty() && operatorPrecedenceCondition(exp, i, ops))
                {
                    res.append(ops.pop());
                    res.append(' ');
                }
                ops.push(ch);
            }
        }

        while (!ops.isStackEmpty())
        {
            res.append(ops.pop());
            res.append(' ');
        }

        return res.toString();
    }
}
