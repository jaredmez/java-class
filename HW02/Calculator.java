import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.print("List of operations: add subtract multiply divide alphabetize\n");
        System.out.print("Enter an operation:\n");
        Scanner sc = new Scanner(System.in);
        String operation = sc.next().toLowerCase();

        switch (operation) {
            case "add", "subtract": {
                System.out.println("Enter two integers:");

                try {
                    int num1 = sc.nextInt();
                    int num2 = sc.nextInt();
                    if (operation.equals("add")) {
                        System.out.println("Answer: " + (num1 + num2));
                    } else {
                        System.out.println("Answer: " + (num1 - num2));
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            }
            case "multiply", "divide": {
                System.out.println("Enter two doubles:");

                try{
                    double num1 = sc.nextDouble();
                    double num2 = sc.nextDouble();
                    if (operation.equals("multiply")) {
                        System.out.printf("Answer: %.2f", num1 * num2);
                        System.out.println();
                    } else {
                        if (num2 == 0) {
                            System.out.println("Invalid input entered. Terminating...");
                            break;
                        }
                        System.out.printf("Answer: %.2f", num1 / num2);
                        System.out.println();
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            }
            case "alphabetize": {
                System.out.println("Enter two words:");
                try {
                    String word1 = sc.next();
                    String word2 = sc.next();

                    int res = word1.compareTo(word2);
                    if (res == 0 || word1.toLowerCase().equals(word2.toLowerCase())) {
                        System.out.println("Answer: Chicken or Egg.");
                    } else if (res > 0) {
                        System.out.printf("Answer: %s comes before %s alphabetically.\n", word2, word1);
                    } else {
                        System.out.printf("Answer: %s comes before %s alphabetically.\n", word1, word2);
                    }
                } catch (Exception e) {
                    System.out.println("Invalid input entered. Terminating...");
                }
                break;
            }
            default:
                System.out.println("Invalid input entered. Terminating...");
        }
    }
}