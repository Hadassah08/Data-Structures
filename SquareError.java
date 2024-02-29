import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SquareError {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input any number to find the square root: ");
        int number; //defining the variable
        do {
            try {
                number = scanner.nextInt(); //allows user to input a number
                if (number < 0) {
                    //throws this new exception
                    throw new Exception("You can't take the square root of a negative number");
                }

                //define the variable for the square root and used math.sqrt(number) to find the
                //square root of the inputted number
                double sqrt = Math.sqrt(number);
                System.out.println("The square root of " + number + " is "  + sqrt);
                //I used a general exception in case the error I input is wrong
            } catch (Exception exception) {
                System.out.println("Error: " + exception.getMessage());
                System.out.println("Try again: ");
                scanner.nextLine(); //allows the user to input a different number
                number = -1; //sets number to -1 to stay in loop
            }

        }while (number < 1); //continues this loop while this condition is satisfied
    }
}