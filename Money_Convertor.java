import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Money_Convertor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double cents = sc.nextDouble();

        int amount = (int) Math.round(cents * 100);

        int quarters =(int) amount / 25;
        double balance  = amount % 25;

        int dimes = (int) balance / 10;
        balance = balance % 10;

        int nickel = (int) balance / 5;
        balance = balance % 5;

        int penny = (int) balance;

        cents = cents * 12;

        System.out.println("Your inputted amount is  ₵" + cents + " in Ghana Cedis");
        System.out.println("Quarter: " + quarters);
        System.out.println("Dime: " + dimes);
        System.out.println("Nickel: " + nickel);
        System.out.println("Penny: " + penny);


    }
}