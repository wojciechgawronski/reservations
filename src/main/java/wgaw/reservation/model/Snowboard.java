package wgaw.reservation.model;

import wgaw.reservation.EquipmentType;

public class Snowboard extends Equipment
{
    private final String size;

    public Snowboard(String serialNumber, String conditions, EquipmentType type, String size)
    {
        super(serialNumber, conditions, type);
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    @Override
    public String getDetails()
    {
        return "Snowboard details: Serial: "+getSerialNumber()+" ,conditions: "+getConditions()+", size: "+ getSize();
    }
}
