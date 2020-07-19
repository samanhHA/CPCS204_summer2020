
package OnlineGroceryPickupSystem;

import java.util.*;
import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

public class OnlineOrderMenu {

    static OnlineGroceryQueue validQ = new OnlineGroceryQueue();
    static OnlineGroceryStack validS = new OnlineGroceryStack();

    static int orderID = 1000;

    public static void main(String[] args) throws FileNotFoundException {

        //creat the output file 
        File outputFile = new File("output.txt");
        PrintWriter output = new PrintWriter(outputFile);

        Scanner input = new Scanner(System.in);
        Scanner line = new Scanner(System.in); //this scanner for nextLine 
        int choice;
        do {
            System.out.print("1. Add a new order"
                    + "\n2. Lookup the first order"
                    + "\n3. Fulfill order"
                    + "\n4. Print orders"
                    + "\n5. Exit"
                    + "\nEnter your choice: ");

            choice = input.nextInt();
            switch (choice) {
                case (1):
                    addOrder(input, line);
                    break;
                case (2):
                    System.out.println(validQ.peek());
                    break;
                case (3):
                    fulfillOrder();
                    break;
                case (4):
                    printOrders(output);
                    break;
                case (5):
                    System.exit(0);
            }

        } while (choice != 5);

    }

    public static void addOrder(Scanner input, Scanner Line) {
        System.out.print("\nPlease enter the order information:"
                + "\n\ncustomer ID: ");
        String cusID = input.next();
        System.out.print("customer name: ");
        String cusName = input.next();

        //generate the current time 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();

        System.out.println("order time: " + formatter.format(now));

        //convert orderTime to  String 
        String orderTime = formatter.format(now).toString();

        //pickup time must be +2hours after the order time
        System.out.print("pickup time: ");
        String pickupTime = input.next();

        //check if it's after 2 hours && not more than 24 hours 
        //1.convert String to time
        LocalTime delivary = LocalTime.parse(pickupTime, formatter);

        //conditions
        LocalTime noLess = now.plusHours(2);
        LocalTime noMore = now.plusHours(24);

        while (!delivary.isAfter(noLess) && !delivary.isBefore(noMore)) {
            System.out.print("\nSorry, we only offer delivery after at least two hours of your order"
                    + " Time and less than 24h. Try Again!"
                    + "\npickup time:");
            pickupTime = input.next();
            delivary = LocalTime.parse(pickupTime, formatter);

        }

        System.out.print("order items: ");
        String[] orderItems = Line.nextLine().split(",");
        System.out.print("quantity: ");
        String[] quantities = Line.nextLine().split(",");

        //creat an order 
        Order newOrder = new Order(orderID++, cusName, cusID, orderTime, pickupTime, orderItems, quantities);
        validQ.enqueue(newOrder);
        System.out.println("The order is added!\n-----------------------------------------------");

    }

    public static void fulfillOrder() {
        //1.disply the first order (front in the queue)
        System.out.println("The first order information:\n");
        System.out.println(validQ.peek());

        //2.remove it from the queue 
        Order temp = validQ.dequeue();

        //3.push it into the stack 
        validS.push(temp);

        System.out.println("The order is fulfilled!");

    }

    public static void printOrders(PrintWriter output) {
        //print orders in queue 

        output.println("Order did not fulfill yet:\nThe order information:\n");
        validQ.printQueue(output);

        //print orders in stack 
        output.println("Already Fulfilled orders:\nThe order information:\n");
        validS.printStack(output);

        output.flush();
        output.close();

    }

}
