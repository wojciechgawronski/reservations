package wgaw.reservation;

public class EquipmentFactory {
    public static Equipment createEquipment(
            EquipmentType type,
            String serialNumber,
            String condition,
            String size
    ) {
        switch (type) {
            case SKI -> {
                return new Ski(serialNumber, condition, EquipmentType.SKI, size);
            }

            case SNOWBOARD -> {
                return new Snowboard(serialNumber, condition, EquipmentType.SNOWBOARD, size);
            }

            default -> throw new IllegalArgumentException("Unsupported equipment type: " + type);
        }
    }
}
