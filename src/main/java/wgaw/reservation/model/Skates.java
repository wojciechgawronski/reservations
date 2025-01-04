package wgaw.reservation.model;

import wgaw.reservation.Equipment;
import wgaw.reservation.EquipmentType;

public class Skates extends Equipment {
    private String size;

    public Skates(String serialNumber, String conditions, EquipmentType type, String size)
    {
        super(serialNumber, conditions, EquipmentType.SKATES);
    }

    public String getDetails(){
        return "Details: SN: "+ getSerialNumber() + ", type: " + getEquipmentType() + ", cond:" + getConditions();
    }
}
