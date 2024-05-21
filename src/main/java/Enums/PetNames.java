package Enums;

public enum PetNames {
    BUDDY("Buddy"),
    FIDO("Fido"),
    FLUFFY("Fluffy"),
    LASSIE("Lassie"),
    REX("Rex"),
    GUPPY("Guppy Taro"),
    MOHU("Mohu"),
    LUNA_ROSE("Luna Rose");

    private final String name;

    PetNames(String name){ this.name = name;}

    public String getName() {
        return name;
    }
}
