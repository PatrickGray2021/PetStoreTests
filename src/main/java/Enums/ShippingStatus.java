package Enums;

public enum ShippingStatus {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String name;

    ShippingStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}