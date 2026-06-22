import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);
        char cInput;

        title();
        sc.nextLine();

        do{
            System.out.println("Select an option:");
            System.out.println("<1> Infix to Prefix");
            System.out.println("<2> Prefix to Infix");
            System.out.println("<X> Exit Program");
            System.out.print("Input here: ");
            cInput = sc.nextLine().charAt(0);

            System.out.println("____________________________________________________________\n\n");

            switch (cInput)
            {
                case '1':
                    do{
                        System.out.println("Type in your infix expression!");
                        System.out.println("Make sure that operands and operators are separated by a space!");
                        System.out.println("Or input \"XXX\" to exit the mode.\n");
                        System.out.print("Input here: ");

                        input = sc.nextLine();

                        if (!(input.equals("XXX") || input.equals("xxx")))
                        {
                            System.out.println("Prefix conversion: " + Prefix.convertToPrefix(input));
                            System.out.println("Answer: " + Prefix.evaluate(Prefix.convertToPrefix(input)));
                        }
                        System.out.println("____________________________________________________________\n\n");
                    } while (!(input.equals("XXX") || input.equals("xxx")));

                    break;
                case '2':
                    do{
                        System.out.println("Type in your prefix expression!");
                        System.out.println("Make sure that operands and operators are separated by a space!");
                        System.out.println("Or input \"XXX\" to exit the mode.\n");
                        System.out.print("Input here: ");

                        input = sc.nextLine();

                        if (!(input.equals("XXX") || input.equals("xxx")))
                        {
                            System.out.println("Infix conversion: " + Prefix.convertToInfix(input));
                            System.out.println("Answer: " + Prefix.evaluate(input));
                        }
                        System.out.println("____________________________________________________________\n\n");
                    } while (!(input.equals("XXX") || input.equals("xxx")));

                    break;
                case 'X':
                case 'x':
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid input!");
            }

        } while (cInput != 'X' && cInput != 'x');
    }

    public static void title() {
        System.out.println("███ █   █ █████ ███ █   █            ████  ████  █████ █████ ███ █   █ ");
        System.out.println(" █  ██  █ █      █   █ █             █   █ █   █ █     █      █   █ █  ");
        System.out.println(" █  █ █ █ ████   █    █      ████    ████  ████  ████  ████   █    █   ");
        System.out.println(" █  █  ██ █      █   █ █             █     █  █  █     █      █   █ █  ");
        System.out.println("███ █   █ █     ███ █   █            █     █   █ █████ █     ███ █   █ \n");
        System.out.println("                        ...and vice versa                              \n");
        System.out.println("                     Press enter to continue...                        ");
        System.out.println("_______________________________________________________________________");
    }
}
