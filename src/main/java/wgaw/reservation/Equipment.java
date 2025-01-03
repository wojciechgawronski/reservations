package wgaw.reservation;

abstract public class Equipment {
    String serialNumber;
    String conditions;
    enum EquipmentType {}
    EquipmentType equipmentType;

    abstract public String getDetails();
}
