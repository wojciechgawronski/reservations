package wgaw.reservation;

public class Ski extends Equipment  {
    private String size;

    public Ski(String serialNumber,
               String conditions,
               wgaw.reservation.EquipmentType equipmentType,
               String size
               ) {
        super(serialNumber,conditions, equipmentType);
        this.size = size;

    }

    public String getSize() {
        return size;
    }

    @Override
    public String getDetails() {
        return "Ski details: Serial: "+getSerialNumber()+" ,conditions: "+getConditions()+", size: "+getSize();
    }
}
