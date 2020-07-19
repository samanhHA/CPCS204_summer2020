
import java.util.Scanner;

public class TreeApplication {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Scanner line = new Scanner(System.in);
        int choice;
        Tree tree = new Tree();
        System.out.println("   Tree System");

        do {
            System.out.print("1.Construct Tree"
                    + "\n2.Insert a node"
                    + "\n3.Search for a node"
                    + "\n4.Delete a node"
                    + "\n5.Compute total sum"
                    + "\n6.Exit"
                    + "\n\nEnter your choice: ");

            choice = input.nextInt();
            if (choice == 1) {
                if (!tree.isEmpty()) {    //if the user enter 1 after he already enter 1 and inserted values, it will clear the entire tree and creat new one
                    tree.clear();
                    System.out.println("\nThe tree had been deleted, you are creating a new one\n");
                }

                constructTree(tree, line);
            }
            if (choice == 2) {
                insertNode(tree, line);
            }
            if (choice == 3) {
                searchNode(tree, input);
            }
            if (choice == 4) {
                deleteNode(tree, input);
            }
            if (choice == 5) {
                sumNodes(tree);
            }

        } while (choice != 6);

        if (choice == 6) {
            System.exit(0);
        }
    }

    public static void constructTree(Tree tree, Scanner line) {
        System.out.print("Enter nodes values (sebrated by comma): ");
        String[] values = line.nextLine().split(",");
        int[] intValues = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            intValues[i] = Integer.parseInt(values[i]);
            //check if the value exist in the tree or not 
            if (tree.search(intValues[i])) {
                System.out.println("\n" + intValues[i] + " Already Exist!\n");
            } else {
                tree.insert(intValues[i]);
                System.out.println("\n" + intValues[i] + " was successfully inserted\n");
            }

        }

    }

    public static void insertNode(Tree tree, Scanner line) {

        System.out.print("Enter value to insert:");
        String[] insValue = line.nextLine().split(",");
        int[] intValues = new int[insValue.length];
        for (int i = 0; i < insValue.length; i++) { 
            intValues[i] = Integer.parseInt(insValue[i]);
            //check if the value exist in the tree or not 
            if (tree.search(intValues[i])) {
                System.out.println("\n" + intValues[i] + " Already Exist!\n");
            } else {
                tree.insert(intValues[i]);
                System.out.println("\n" + intValues[i] + " was successfully inserted\n");
            }
            System.out.println();

        }

    }

    public static void searchNode(Tree tree, Scanner input) {
        System.out.print("Enter the value you search for: ");
        int data = input.nextInt();
        if (tree.search(data)) {
            System.out.println("\n" + data + " was found in the tree\n");
        } else {
            System.out.println("\n" + data + " was not found in the tree\n");
        }

    }

    public static void deleteNode(Tree tree, Scanner input) {
        System.out.print("Enter the value you want to be deleted: ");
        int value = input.nextInt();

        //check if the value in the tree 
        if (tree.search(value) == false) {
            System.out.println("\nThis value does not exist in the tree!\n");
        } else {
            tree.delete(value);
            System.out.println("\nThis value was successfully deleted\n");
        }

    }

    public static void sumNodes(Tree tree) {
        if (tree.isEmpty()) {
            System.out.println("Sorry, The tree is Empty!\n");
        } else {
            System.out.println("The sum of all nodes is: "
                    + tree.sumNodes() + "\n");
        }
    }

}
