import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String[] items = {
            "Burger",
            "Fries",
            "Spaghetti",
            "Chicken",
            "Soft Drink"
        };

        double[] prices = {
            100.00,
            80.00,
            120.00,
            150.00,
            50.00
        };

        int totalQuantity = 0;
        double totalAmount = 0.0;

        // Get customer status
        System.out.print("Are you a student? (Y/N): ");
        String studentStatus = input.next();

        while (!studentStatus.equalsIgnoreCase("Y")
                && !studentStatus.equalsIgnoreCase("N")) {

            System.out.println("Invalid input! Please enter Y or N.");
            System.out.print("Are you a student? (Y/N): ");
            studentStatus = input.next();
        }

        System.out.println("\n=================================");
        System.out.println("       CANTEEN ORDERING SYSTEM");
        System.out.println("=================================");

        String orderAgain = "Y";

        while (orderAgain.equalsIgnoreCase("Y")) {

            // Display menu
            System.out.println("\nMENU");
            System.out.println("---------------------------------");

            for (int i = 0; i < items.length; i++) {
                System.out.printf("%d. %-15s PHP %.2f%n",
                        i + 1, items[i], prices[i]);
            }

            System.out.println("---------------------------------");

            // Get order
            System.out.print("Enter item number: ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            // Validate item number
            if (itemNumber < 1 || itemNumber > items.length) {
                System.out.println("Invalid item number!");
                System.out.println("Order was not added.");
                continue;
            }

            // Validate quantity
            if (quantity < 1 || quantity > 10) {
                System.out.println("Invalid quantity!");
                System.out.println("Quantity must be from 1 to 10.");
                continue;
            }

            // Calculate order
            double orderAmount = prices[itemNumber - 1] * quantity;

            totalQuantity += quantity;
            totalAmount += orderAmount;

            System.out.println("\nOrder added successfully!");
            System.out.println("Item: " + items[itemNumber - 1]);
            System.out.println("Quantity: " + quantity);
            System.out.printf("Amount: PHP %.2f%n", orderAmount);

            // Ask if customer wants another order
            System.out.print("\nDo you want to order again? (Y/N): ");
            orderAgain = input.next();

            while (!orderAgain.equalsIgnoreCase("Y")
                    && !orderAgain.equalsIgnoreCase("N")) {

                System.out.println("Invalid input! Please enter Y or N.");
                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = input.next();
            }
        }

        // Determine deduction
        double deductionRate;

        if (studentStatus.equalsIgnoreCase("Y")
                && totalAmount >= 500) {

            deductionRate = 0.15;

        } else if (studentStatus.equalsIgnoreCase("Y")) {

            deductionRate = 0.10;

        } else if (totalAmount >= 500) {

            deductionRate = 0.05;

        } else {

            deductionRate = 0.00;
        }

        double totalDeduction = totalAmount * deductionRate;
        double finalAmount = totalAmount - totalDeduction;

        // Final computation
        System.out.println("\n=================================");
        System.out.println("          ORDER SUMMARY");
        System.out.println("=================================");

        System.out.println("Total quantity of items: "
                + totalQuantity);

        System.out.printf("Total amount before deductions: PHP %.2f%n",
                totalAmount);

        System.out.printf("Total deduction: PHP %.2f%n",
                totalDeduction);

        System.out.printf("Final amount to pay: PHP %.2f%n",
                finalAmount);

        System.out.println("=================================");

        input.close();
    }
}