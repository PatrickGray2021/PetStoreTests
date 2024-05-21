package Enums;

public enum Categories {
    DOG("dog"),
    CAT("cat"),
    FISH("fish");

   private final String name;

   Categories(String name){ this.name = name;}

    @Override
    public String toString() {
        return this.name;
    }
}
