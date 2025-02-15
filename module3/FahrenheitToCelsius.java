import java.util.Scanner;

public class FahrenheitToCelsius {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in); //read keyboard input
//        System.out.print("Enter a Fahrenheit value: ");
//        int fahrenheitValue = input.nextInt();
//        System.out.print("Enter a day of the week: ");
//        input.nextLine();
//        String day = input.nextLine();
//
//        double celsius = (5.0/9) * (fahrenheitValue - 32);
//
//        System.out.println(day + " Fahrenheit: " + fahrenheitValue);
//        System.out.println(day + " Celsius: " + celsius);
//    }


    //-----Formatting with printf -------------------

//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in); //read keyboard input
//        System.out.print("Enter a Fahrenheit value: ");
//        int fahrenheitValue = input.nextInt();
//        System.out.print("Enter a day of the week: ");
//        input.nextLine();
//        String day = input.nextLine();
//        System.out.print("Enter your preferred Celsius label (Celsius, Centigrade, or C): ");
//        String ctext = input.next();
//
//        double celsius = (5.0/9) * (fahrenheitValue - 32);
//
//        System.out.println(day + " Fahrenheit: " + fahrenheitValue);
//        System.out.printf("%s %-10s: %.1f\n", day, ctext, celsius);
//    }

    // ---- Adding conditional statements
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Fahrenheit value: ");
        int fahrenheit = input.nextInt();
        System.out.print("Enter a day of the week: ");
        String day = input.next();
        double celsius = (5.0/9) * (fahrenheit - 32);
        System.out.println(day + " Fahrenheit: " + fahrenheit);
        System.out.printf("%s %.1f \n", day + " Celsius:", celsius);

        if (fahrenheit > 70)
            System.out.println("Yay! Go to park.");
        else
            System.out.println("Stay home where there's wifi and learn 1331.");

    }
}
