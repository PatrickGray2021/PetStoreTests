package Enums;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

   private final String name;

   Status(String name){ this.name = name;}

    @Override
    public String toString() {
        return this.name;
    }
}
