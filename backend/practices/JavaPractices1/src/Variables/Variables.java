package Variables;
import java.util.Scanner;

public class Variables {

    public static void main(String[] args) {
        //Exercise on Variables, Datatype and Operator
        System.out.println("In the Variable Section");

        //Non-primitive data types: arrays and classes
        //Store multiple values
        //Objects
        String name = "Jean Looi";
        String firstName = "Jean";
        String lastName = "Looi";

        //Primitive data types - raw value, one value per variable
        int age = 18;
        age = 20;
        final int cost = 15;
        //cost = 20; //Error
        double totalPrice = 1500.60;
        boolean isHungry = false;
        char gender = 'f';

        //seldom used
        float price = 15.99f; //floating point datatype, value requires f at the end
        byte a = 50;
        short b = 12345;
        long c = 123456789;

        double castMyage = age; //20.0 - widening casting
        int castTotalPrice = (int) totalPrice; //1500 - narrowing casting

        System.out.println("My name is " + name + " I am " + age + " years old. My gender is " + gender + " and the total price I need to pay is " + totalPrice);

        String showMessage = String.format("My name is %s %s, I am %d years old. My gender is %c and the total price I need to pay is %.2f.",firstName, lastName, age, gender, totalPrice);
        System.out.println(showMessage);

        //Alternative to above
        System.out.printf("My name is %s %s, I am %d years old. My gender is %c and the total price I need to pay is %.2f.",firstName, lastName, age, gender, totalPrice);

        int num1 = 10, num2 = 20, num3 = 30;

        //num1 == num2 //false
        //num1 > num2 //false
        //num1 < num2 && num1 < num3 //true

        String name1 = "hello"; String name2 = "Hello";
        System.out.println(name1.equals(name2)); //false
        System.out.println(name1.equalsIgnoreCase(name2)); //true
        System.out.println(name1.compareTo(name2));


        //Create a Scanner object to get input from terminal
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter your username: ");

        String userName = input.nextLine(); //Read user input

        //System.out.println("Hello and Welcome " + userName);

        //Compare last name that user input with the last name variable
        //if user keeps entering wrong last name, we will keep prompting user to enter the last name

        //Loop
        while (!(userName.equalsIgnoreCase(lastName))) {
            if (false) {
                System.out.println("Hello and Welcome " + lastName);
                break;
            }
            else {
                System.out.println("Last name is incorrect. Please try again.");
                System.out.printf("Enter your username: ");
                userName = input.nextLine();
            }
        }


    }
}
