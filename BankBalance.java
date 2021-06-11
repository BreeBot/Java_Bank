import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankBalance {

  public static final String INPUT_FILE = "fry.txt";
  //325 : verified in excel

  public static void main(String[] args) throws FileNotFoundException {
    File fry = new File(INPUT_FILE);
    System.out.println(fry.exists());
    Scanner scanner = new Scanner(fry);


    //int result = 0;
    double totalBalance = 0;
    int withDrwl = 0;
    int numWithDrwl = 0;
    int highDeposit = Integer.MIN_VALUE;




    while (scanner.hasNextLine()) {
      int currentLine = scanner.nextInt();
      totalBalance += (currentLine);

      if (currentLine < 0) {
        withDrwl += currentLine;
        numWithDrwl ++;
      }
      if (currentLine > highDeposit){
        highDeposit = currentLine;

      }
    }

    double avgWithDrwl = (double) withDrwl/numWithDrwl;

    System.out.println("Fry's balance: $" + totalBalance);
    System.out.println("The total amount withdrawn: $" + withDrwl);
    System.out.println("The number of withdrawals made: " + numWithDrwl);
    System.out.println("Average Withdrawal: $" + avgWithDrwl);
    System.out.println("The largest deposit: $" + highDeposit);


    double num1 = getCost("Hi Fry, how much does the car you want cost?");

    while (totalBalance < num1) {
      num1 = getCost("You don't have enough money. Please enter a lower amount");
    }
    System.out.println("You have enough money!");

  }
  public static double getCost(String prompt) {
    System.out.println(prompt);
    Scanner carCost = new Scanner(System.in);
    String userInput = carCost.nextLine();

    while (userInput.isEmpty()) {
      System.out.println("Invalid input" + prompt);
      userInput = carCost.nextLine();
    }
    double num1 = Double.parseDouble(userInput);
    return num1;
  }
}



