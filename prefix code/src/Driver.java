import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String input;
        Scanner sc = new Scanner(System.in);

        title();
        sc.nextLine();

        do{
            System.out.println("Type in your infix expression!");
            System.out.println("Make sure that operands and operators are separated by a space!");
            System.out.println("Or input \"XXX\" to exit.\n");
            System.out.print("Input here: ");

            input = sc.nextLine();

            if (!(input.equals("XXX") || input.equals("xxx")))
            {
                System.out.println("Prefix conversion: " + Prefix.convertToPrefix(input));
                System.out.println("Answer: " + Prefix.evaluate(Prefix.convertToPrefix(input)));
            }
            System.out.println("____________________________________________________________\n\n");
        } while (!(input.equals("XXX") || input.equals("xxx")));

        System.out.println("Exiting program...");
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