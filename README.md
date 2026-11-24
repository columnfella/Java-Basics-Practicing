# Java Basics Practice

Exercises covering core Java and object-oriented programming.

## Projects

### Minecraft Item Manager

A console application for managing an inventory of Minecraft-style items (tools, weapons and armor), each with a name, type and durability.

**Features**

- Menu-driven interface to add, remove, replace and display items
- Input validation with clear error messages
- Saving and loading the inventory to disk with Java serialization
- A custom `Comparator` for sorting items by durability

**Concepts practiced**

- Classes, encapsulation and enums (`Item`, `ItemType`)
- Collections and custom comparators (`ItemCollection`, `DurabilityComparator`)
- Custom exceptions (`DuplicateItemFoundException`, `ItemNotFoundException`)
- File I/O with object serialization (`ItemSerializer`)

## Running it

Requires JDK 17 or newer.

```bash
cd MinecraftItemManager/src
javac Main.java Items/*.java Comparators/*.java
java Main
```

You can also open the `MinecraftItemManager` folder in IntelliJ IDEA and run `Main`.
