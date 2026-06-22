============================================================================================

CCDSALG MCO1: Infix to Prefix Converter and Calculator

============================================================================================



DESCRIPTION:

This Java program allows the user to type in a mathematical infix expression, which the

program calculates via converting the expression into its prefix form and evaluating it from

there.



HOW TO USE:

The user will see the title card upon boot-up. Press enter to continue.



In inputting infix expressions in the program, the user must follow a set of guidelines in

typing the infix expression.



\- Make sure to put 1 space in between operands and operators. Parentheses, however, can be

&#x20; inputted without a space.

&#x09;\* e.g. (1 + 2) - 3

\- Make sure the inputted expression is a valid mathematical expression.

&#x09;\* Make sure parentheses are paired properly

&#x09;\* Do not use invalid characters (e.g., '$' or '?')

&#x09;\* Make sure to put operators in between operands (however, the unary '-' operator is

&#x09;  considered valid).

\- When inputting the unary negative operator, make sure there is only one for the whole

&#x20; operand.

&#x09;\* Valid: -1028

&#x09;\* Invalid: ---2006

\- The unary '-' operator only works with respect to grouped expressions at the BEGINNING of

&#x20; the expression. It must be separated by a space, however.

&#x09;\* Valid: - (1 + 2)

&#x09;\* Invalid: 4 + - (1 + 2)

&#x09;	\* Correct: 4 - (1 + 2)



Upon inputting the infix expression, the program will then display both the prefix

equivalent of the expression and the evaluated result. However, if the given expression is

invalid, an error message will display, and the user will be prompted again to enter another

expression.



If the user wishes to exit the program, they must input "XXX" or "xxx", which ends the loop

and exits the program.



AUTHORS:

\* Maullon, Edriel Lexine A. \[12512079]

\* Tolentino, Johann Haree G. \[12506494]



REFERENCES:



Mahapatra, S. (2025, September 15). *Infix to prefix notation.* GeeksforGeeks.

&#x09;https://www.geeksforgeeks.org/dsa/convert-infix-prefix-notation/



Mahapatra, S. (2025, September 15). *Evaluation of prefix expressions.* GeeksforGeeks.

&#x09;https://www.geeksforgeeks.org/dsa/evaluation-prefix-expressions/

