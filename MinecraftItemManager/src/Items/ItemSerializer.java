package Items;

import java.io.*;
import java.util.*;

public class ItemSerializer {
    private static final String path = "data/data.ser";

    public static void save(List<Item> items) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            int i = 1;

            for(Item item : items) {
                out.writeObject(item);
                System.out.println("Object "+i+"serialized successfully.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Object serialization failed.");
        }
    }

    public static List<Item> load() throws EOFException {
        List<Item> items = new ArrayList<>();
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            int i = 1;
            while (true) {
                try {
                    Item item = (Item) in.readObject();
                    items.add(item);
                    System.out.println("Object " + i + " deserialized successfully.");
                    i++;
                } catch (EOFException e) {
                    // End of file reached, exit the loop
                    break;
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Object deserialization failed.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Object deserialization failed.");
        }
        return items;
    }
}
