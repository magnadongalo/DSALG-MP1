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

- Make sure to put 1 space in between operands and operators. Parentheses, however, can be
  inputted without a space.
	* e.g. (1 + 2) - 3
- Make sure the inputted expression is a valid mathematical expression. 
	* Make sure parentheses are paired properly
	* Do not use invalid characters (e.g., '$' or '?')
	* Make sure to put operators in between operands (however, the unary '-' operator is
	  considered valid).
- When inputting the unary negative operator, make sure there is only one for the whole
  operand.
	* Valid: -1028
	* Invalid: ---2006

Upon inputting the infix expression, the program will then display both the prefix
equivalent of the expression and the evaluated result. However, if the given expression is
invalid, an error message will display, and the user will be prompted again to enter another
expression.

If the user wishes to exit the program, they must input "XXX" or "xxx", which ends the loop
and exits the program.