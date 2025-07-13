package Items;

import java.util.*;

import static java.util.Collections.sort;

public class ItemCollection {
    private List<Item> items;

    public ItemCollection() {
        items = new ArrayList<>();
    }

    public boolean addItem(Item item) throws DuplicateItemFoundException {
        ListIterator<Item> iterator = items.listIterator();
        Item iter;

        while(iterator.hasNext()) {
            iter = iterator.next();
            if(iter.equals(item)) {
                throw new DuplicateItemFoundException("Duplicate Item found.");
            }
        }
        return items.add(item);
    }

    public boolean removeItem(Item item) {
        return items.remove(item);
    }

    public boolean containsItem(Item item) {
        return items.contains(item);
    }

    public Item searchItem(String name) throws ItemNotFoundException {
        ListIterator<Item> iterator = items.listIterator();
        Item iter;

        while(iterator.hasNext()) {
            iter = iterator.next();
            if(iter.getName().equals(name)) {
                return iter;
            }
        }

        throw new ItemNotFoundException("Item not found.");
    }

    public void replaceItem(Item itemToReplace, String name) throws ItemNotFoundException {
        ListIterator<Item> iterator = items.listIterator();
        Item iter;

        while(iterator.hasNext()) {
            iter = iterator.next();

            if(iter.getName().equals(name)) {
                iterator.set(itemToReplace);
                return;
            }
        }
        throw new ItemNotFoundException("Item not found.");
    }

    public List<Item> findItemsWithDurability(int durability) throws ItemNotFoundException {
        ListIterator<Item> iterator = items.listIterator();
        List<Item> itemsWithDurability = new ArrayList<>();
        Item iter;

        while(iterator.hasNext()) {
            iter = iterator.next();
            if(iter.getDurability() == durability) {
                itemsWithDurability.add(iter);
            }
        }

        if(!itemsWithDurability.isEmpty()) {
            return itemsWithDurability;
        } else {
            throw new ItemNotFoundException("No items found with the specified durability.");
        }
    }

    public void sortItems(Comparator<Item> c) {
        sort(this.items, c);
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        String st = "";

        for(Item item : items) {
            st += item.toString();
            st += "\n";
        }
        return st;
    }
}
