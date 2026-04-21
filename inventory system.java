import java.util.*;

public class InventoryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // HashMap for storing item name and quantity
        HashMap<String, Integer> inventory = new HashMap<>();

        while (true) {
            try {
                System.out.println("\n1. Add Item");
                System.out.println("2. Update Stock");
                System.out.println("3. View Inventory");
                System.out.println("4. Remove Item");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter item name: ");
                        String item = sc.nextLine();

                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();

                        inventory.put(item, qty);
                        System.out.println("Item added successfully!");
                        break;

                    case 2:
                        System.out.print("Enter item name: ");
                        String updateItem = sc.nextLine();

                        if (inventory.containsKey(updateItem)) {
                            System.out.print("Enter new quantity: ");
                            int newQty = sc.nextInt();
                            inventory.put(updateItem, newQty);
                            System.out.println("Stock updated!");
                        } else {
                            System.out.println("Item not found!");
                        }
                        break;

                    case 3:
                        if (inventory.isEmpty()) {
                            System.out.println("Inventory is empty.");
                        } else {
                            System.out.println("\n--- Inventory ---");
                            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                                System.out.println("Item: " + entry.getKey() +
                                                   ", Quantity: " + entry.getValue());
                            }
                        }
                        break;

                    case 4:
                        System.out.print("Enter item name to remove: ");
                        String removeItem = sc.nextLine();

                        if (inventory.remove(removeItem) != null) {
                            System.out.println("Item removed!");
                        } else {
                            System.out.println("Item not found!");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Enter numbers only.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}