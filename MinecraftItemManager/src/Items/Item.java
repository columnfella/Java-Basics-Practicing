package Items;

import java.io.Serializable;

public class Item implements Serializable {
    private final long serialVersionUID = 4L;

    private String name;
    private ItemType type;
    private int durability;

    public Item(String name, String type, int durability) throws IllegalArgumentException {
        this.name = name;
        this.type = ItemType.valueOf(type);
        this.durability = durability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type.name();
    }

    public void setType(String type) {
        this.type = ItemType.valueOf(type);
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Item{" +
                "serialVersionUID=" + serialVersionUID +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", durability=" + durability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Item) || o == null) {
            return false;
        } else {
            Item i = (Item) o;
            return i.getName().equals(this.name);
        }
    }
}
