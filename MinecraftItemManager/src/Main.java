import java.io.EOFException;
import java.util.*;
import Items.*;

public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static ItemCollection items = new ItemCollection();
    public static ItemSerializer serializer = new ItemSerializer();

    public static void main(String[] args) {
        int choice;

        System.out.println("--------------------------------------Menu--------------------------------------");
        System.out.println("Welcome to the Minecraft item management menu!");

        do {
            System.out.println("1- Add Item");
            System.out.println("2- Remove Item");
            System.out.println("3- Display Items");
            System.out.println("4- Replace an Item");
            System.out.println("5- Save Items");
            System.out.println("6- Load Items");
            System.out.println("7- Exit");

            System.out.println("Please select an option: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1 -> addItem();
                case 2 -> removeItem();
                case 3 -> displayAllItems();
                case 4 -> replaceItem();
                case 5 -> saveItems();
                case 6 -> loadItems();
                case 7 -> System.out.println("Exiting...");
                default -> System.out.println("You stupid retarded fucker there are only 7 options.");
            }
        } while (choice != 7);
    }

    public static Item createItemFromUserInput() {
        while(true) {
            System.out.println("Enter the name of the item: ");
            String name = sc.nextLine();

            System.out.println("Enter the type of the item {TOOL, WEAPON, ARMOR}: ");
            String type = (sc.nextLine()).toUpperCase();
            try {
                System.out.println("Enter the durability of the item: ");
                int durability = sc.nextInt();
                sc.nextLine();

                Item item = new Item(name, type, durability);
                return item;
            } catch(IllegalArgumentException e) {
                System.out.println("You fucking retard put the correct the correct item type. Dumbass");
            } catch(InputMismatchException e) {
                System.out.println("You fucking faggot piece of shit put the correct value retard.");
                sc.nextLine();
            }
        }
    }

    public static void addItem() {
        while (true) {
            try {
                items.addItem(createItemFromUserInput());
                System.out.println("Item added successfully.");
                break;
            } catch (DuplicateItemFoundException e) {
                System.out.println(e.getMessage());
                if(!wantToTryAgain()) {
                    break;
                }
            }
        }
    }

    public static void removeItem() {
        while (true) {
            try {
                System.out.println("Enter the name of the item: ");
                String name = sc.nextLine();

                Item item = items.searchItem(name);

                items.removeItem(item);
                System.out.println("Item removed successfully.");
                break;
            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
                if(!wantToTryAgain()) {
                    break;
                }
            }
        }
    }

    public static void displayAllItems() {
        System.out.println(items.toString());
    }

    public static void replaceItem() {
        while (true) {
            try {
                System.out.println("Enter the name of the item to replace: ");
                String name = sc.nextLine();

                System.out.println("--------------------Item creation--------------------");
                Item item = createItemFromUserInput();

                items.replaceItem(item, name);
                System.out.println("Item replaced successfully.");
                break;
            } catch (ItemNotFoundException e) {
                System.out.println(e.getMessage());
                if(!wantToTryAgain()) {
                    break;
                }
            }
        }
    }

    public static boolean wantToTryAgain() {
        System.out.println("Enter [1] to try again or [0] to exit: ");
        int tryAgain = sc.nextInt();
        if (tryAgain == 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void saveItems() {
        serializer.save(items.getItems());
    }

    public static void loadItems() {
        try {
            List<Item> loadedItems = serializer.load();
            for (Item item : loadedItems) {
                items.addItem(item);
            }
        } catch (EOFException e) {
            System.out.println(e.getMessage());
            System.out.println("Retard faggot.");
        } catch (DuplicateItemFoundException e) {
            System.out.println("You nigger you just saved and want to load it again are you retarded?");
        }


    }
}

//import java.util.*;
//import Items.*;
//
//public class Main {
//    public static final Scanner sc = new Scanner(System.in);
//    public static ItemCollection items = new ItemCollection();
//    public static ItemSerializer serializer = new ItemSerializer();
//
//    public static void main(String[] args) {
//        int choice;
//
//        System.out.println("--------------------------------------Menu--------------------------------------");
//        System.out.println("Welcome to the Minecraft item management menu!");
//
//        do {
//            System.out.println("1- Add Item");
//            System.out.println("2- Remove Item");
//            System.out.println("3- Display Items");
//            System.out.println("4- Replace an Item");
//            System.out.println("5- Save Items");
//            System.out.println("6- Load Items");
//            System.out.println("7- Exit");
//
//            System.out.print("Please select an option: ");
//            choice = sc.nextInt();
//            sc.nextLine();  // Consume newline
//
//            switch(choice) {
//                case 1 -> addItem();
//                case 2 -> removeItem();
//                case 3 -> displayAllItems();
//                case 4 -> replaceItem();
//                case 5 -> saveItems();
//                case 6 -> loadItems();
//                case 7 -> System.out.println("Exiting...");
//                default -> System.out.println("Invalid option, please select between 1 and 7.");
//            }
//        } while (choice != 7);
//    }
//
//    public static Item createItemFromUserInput() {
//        System.out.println("Enter the name of the item: ");
//        String name = sc.nextLine();
//
//        System.out.println("Enter the type of the item: ");
//        String type = sc.nextLine();
//
//        int durability = 0;
//        while (true) {
//            try {
//                System.out.println("Enter the durability of the item: ");
//                durability = Integer.parseInt(sc.nextLine());  // Parsing integer from line input
//                break;
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input for durability. Please enter a valid number.");
//            }
//        }
//
//        return new Item(name, type, durability);
//    }
//
//    public static void addItem() {
//        while (true) {
//            try {
//                items.addItem(createItemFromUserInput());
//                System.out.println("Item added successfully.");
//                break;
//            } catch (DuplicateItemFoundException e) {
//                System.out.println(e.getMessage());
//                if (!wantToTryAgain()) {
//                    break;
//                }
//            }
//        }
//    }
//
//    public static void removeItem() {
//        while (true) {
//            try {
//                System.out.println("Enter the name of the item: ");
//                String name = sc.nextLine();
//
//                Item item = items.searchItem(name);
//                items.removeItem(item);
//                System.out.println("Item removed successfully.");
//                break;
//            } catch (ItemNotFoundException e) {
//                System.out.println(e.getMessage());
//                if (!wantToTryAgain()) {
//                    break;
//                }
//            }
//        }
//    }
//
//    public static void displayAllItems() {
//        System.out.println(items.toString());
//    }
//
//    public static void replaceItem() {
//        while (true) {
//            try {
//                System.out.println("Enter the name of the item to replace: ");
//                String name = sc.nextLine();
//
//                System.out.println("--------------------Item creation--------------------");
//                Item item = createItemFromUserInput();
//
//                items.replaceItem(item, name);
//                System.out.println("Item replaced successfully.");
//                break;
//            } catch (ItemNotFoundException e) {
//                System.out.println(e.getMessage());
//                if (!wantToTryAgain()) {
//                    break;
//                }
//            }
//        }
//    }
//
//    public static boolean wantToTryAgain() {
//        while (true) {
//            try {
//                System.out.println("Enter [1] to try again or [0] to exit: ");
//                int tryAgain = Integer.parseInt(sc.nextLine());  // Parse input as integer
//
//                if (tryAgain == 0) {
//                    return false;
//                } else if (tryAgain == 1) {
//                    return true;
//                } else {
//                    System.out.println("Invalid option. Please enter 0 or 1.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//            }
//        }
//    }
//
//    public static void saveItems() {
//        serializer.save(items.getItems());
//    }
//
//    public static void loadItems() {
//        List<Item> loadedItems = serializer.load();
//
//        for (Item item : loadedItems) {
//            items.addItem(item);
//        }
//    }
//}
