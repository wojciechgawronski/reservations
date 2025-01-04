package wgaw.reservation.model;

import wgaw.reservation.EquipmentType;

public abstract class Equipment {
    private final String serialNumber;
    private final String conditions;
    private final EquipmentType type;

    public Equipment(String serialNumber, String conditions, EquipmentType type) {
        this.serialNumber = serialNumber;
        this.conditions = conditions;
        this.type = type;
    }

    abstract public String getDetails();

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getConditions() {
        return conditions;
    }

    public EquipmentType getEquipmentType() {
        return type;
    }
}
