package wgaw.reservation;

public class Snowboard extends Equipment
{
    private final String size;

    public Snowboard(String serialNumber, String conditions, EquipmentType type, String size)
    {
        super(serialNumber, conditions, type);
        this.size = size;
    }

    @Override
    public String getDetails()
    {
        return "Snowboard Details: , size: "+size;
    }
}
