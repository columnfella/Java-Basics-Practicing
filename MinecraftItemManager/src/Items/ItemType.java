package Items;

public enum ItemType {
    TOOL("Item to do stuff"),
    WEAPON("Item to kill mobs"),
    ARMOR("Item to protect from damage");

    private String description;

    ItemType(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
}
