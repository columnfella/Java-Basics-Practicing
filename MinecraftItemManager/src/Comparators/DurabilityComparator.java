package Comparators;

import java.util.Comparator;
import Items.Item;

public class DurabilityComparator implements Comparator<Item>{
    public int compare(Item i1, Item i2) {
        return Integer.compare(i1.getDurability(), i2.getDurability());
    }
}
