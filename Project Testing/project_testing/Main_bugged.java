// Bugged File

import java.util.Scanner;

public class Main_bugged
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do
        {
            printServiceMenu();

            System.out.print("Enter your choice (1-2): ");
            choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    placeOrder();
                    break;
                case 2:
                    System.out.println("Exiting Printing Service. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 2);

        scanner.close();
    }

    public static void printServiceMenu()
    {
        System.out.println("Welcome to the printing service! How can we help you today?");
        System.out.println("************ Printing Service ************");
        System.out.println("1. Place Order");
        System.out.println("2. Exit");
        System.out.println("******************************************");
    }

    public static void placeOrder()
    {
        Scanner scanner = new Scanner(System.in);
        int orderType;

        System.out.println("Choose order type:");
        System.out.println("1. Same size, finish, and processing time for all prints");
        System.out.println("2. Different sizes, finish, and processing time for each print");
        System.out.print("Enter your choice (1-2): ");
        orderType = scanner.nextInt();

        handlePrints(orderType);
    }

    public static void handlePrints(int orderType) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of prints (1-100): ");
        int quantity = scanner.nextInt();

        int sizeChoice = 0, finishChoice = 0, timeChoice = 0;
        String enteredCode = "";

        // Get common characteristics if orderType is 1
        if (orderType == 1)
        {
            System.out.println("Choose size:");
            System.out.println("1. 4 x 6");
            System.out.println("2. 5 x 7");
            System.out.println("3. 8 x 10");
            System.out.print("Enter your choice: ");
            sizeChoice = scanner.nextInt();

            System.out.println("Choose finish:");
            System.out.println("1. Glossy");
            System.out.println("2. Matte");
            System.out.print("Enter your choice: ");
            finishChoice = scanner.nextInt();

            System.out.println("Choose processing time:");
            System.out.println("1. Next day");
            System.out.println("2. 1-hour");
            System.out.print("Enter your choice: ");
            timeChoice = scanner.nextInt();

            System.out.print("Enter promotion code (N56M2) if you have one: ");
            enteredCode = scanner.nextLine();
        }

        double totalOrderCost = calculateOrderCost(orderType, quantity, sizeChoice, finishChoice, timeChoice, enteredCode);
        System.out.println("Total Cost for " + quantity + " prints: $" + totalOrderCost);
    }

    public static double calculateOrderCost(int orderType, int quantity, int sizeChoice, int finishChoice, int timeChoice, String enteredCode)
    {
        Scanner scanner = new Scanner(System.in);
        double baseCost = 0.0;

        if (orderType == 1)
        {
            // Pricing logic for same size, finish, and processing time for all prints
            baseCost = calculateBaseCost(sizeChoice, quantity);
            baseCost = applyFinishCost(baseCost, sizeChoice, finishChoice);
            baseCost = applyProcessingTimeCost(baseCost, quantity, timeChoice, orderType);



            baseCost = applyPromotionCodeDiscount(baseCost, quantity, enteredCode);

        }
        else if (orderType == 2)
        {
            // Pricing logic for different sizes, finish, and processing time for each print
            for (int i = 1; i <= quantity; i++)
            {
                System.out.println("Details for Print #" + i);
                System.out.println("Choose size:");
                System.out.println("1. 4 x 6");
                System.out.println("2. 5 x 7");
                System.out.println("3. 8 x 10");
                System.out.print("Enter your choice: ");
                sizeChoice = scanner.nextInt();

                System.out.println("Choose finish:");
                System.out.println("1. Glossy");
                System.out.println("2. Matte");
                System.out.print("Enter your choice: ");
                finishChoice = scanner.nextInt();

                System.out.println("Choose processing time:");
                System.out.println("1. Next day");
                System.out.println("2. 1-hour");
                System.out.print("Enter your choice: ");
                timeChoice = scanner.nextInt();

                baseCost += calculateBaseCost(sizeChoice, quantity);
                baseCost = applyFinishCost(baseCost, sizeChoice, finishChoice);
                baseCost = applyProcessingTimeCost(baseCost, quantity, timeChoice, orderType);
            }
        }

        // Apply 5% reduction if the cost is more than $35.00
        if (baseCost > 35.00 )
        {
            baseCost *= 0.95;
        }

        return baseCost;
    }

    public static double calculateBaseCost(int sizeChoice, int quantity)
    {
        // Calculate base cost based on size and quantity
        double baseCost = 0.0;

        switch (sizeChoice)
        {
            case 1: // 4 x 6 size
                if (quantity <= 50)
                {
                    baseCost = quantity * 0.14;
                }
                else if (quantity <= 75)
                {
                    baseCost = 50 * 0.14 + (quantity - 50) * 0.12;
                }
                else
                {
                    baseCost = 50 * 0.14 + 25 * 0.12 + (quantity - 75) * 0.10;
                }
                break;
            case 2: // 5 x 7 size
                if (quantity <= 50)
                {
                    baseCost = quantity * 0.34;
                }
                else if (quantity <= 75)
                {
                    baseCost = 50 * 0.34 + (quantity - 50) * 0.31;
                }
                else
                {
                    baseCost = 50 * 0.34 + 25 * 0.31 + (quantity - 75) * 0.28 + .10;
                }
                break;
            case 3: // 8 x 10 size
                if (quantity <= 50)
                {
                    baseCost = quantity * 0.68;
                }
                else if (quantity <= 75)
                {
                    baseCost = 50 * 0.68 + (quantity - 50) * 0.64;
                }
                else
                {
                    baseCost = 50 * 0.68 + 25 * 0.64 + (quantity - 75) * 0.60;
                }
                break;
            default:
                break;
        }

        return baseCost;
    }

    public static double applyFinishCost(double baseCost, int sizeChoice, int finishChoice)
    {
        // Apply finish cost based on size
        switch (sizeChoice)
        {
            case 1:
                return (finishChoice == 2) ? baseCost + 0.04 : baseCost; // 4 x 6 size
            case 2:
                return (finishChoice == 2) ? baseCost + 0.06 : baseCost; // 5 x 7 size
            case 3:
                return (finishChoice == 2) ? baseCost + 0.08 : baseCost; // 8 x 10 size
            default:
                return baseCost;
        }
    }

    public static double applyProcessingTimeCost(double baseCost, int quantity, int timeChoice, int orderType)
    {
        // Apply processing time cost
        if (orderType == 1)
        {
            if (timeChoice == 2)
            {  // 1-hour processing time
                if (quantity <= 60)
                {
                    return baseCost + 1.00;
                }
                else
                {
                    return baseCost + 1.50;
                }
            }
            else
            {
                return baseCost;
            }
        }
        else if (timeChoice == 2)
            {  // 1-hour processing time
            if (quantity <= 60)
            {
                return baseCost + 2.00;
            }
            else
            {
                return baseCost + 2.50;
            }
            }
        else
        {
            return baseCost;
        }
    }

    public static double applyPromotionCodeDiscount(double baseCost, int quantity, String enteredCode)
    {
        // Apply promotion code discount
        if (quantity == 100)
        {
            String promotionCode = "N56M2";
            if (enteredCode.equals(promotionCode))
            {
                // Done to reverse the discount
                baseCost  = (baseCost + (baseCost *.05)) - 2.00;;;
            }
        }

        return baseCost;
    }
}

