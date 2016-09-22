package problem10.enums;

public enum TypeOfWeapon {

    AXE("Axe"),
    SWORD("Sword"),
    KNIFE("Knife");

    private String type;

    TypeOfWeapon(String type) {
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
