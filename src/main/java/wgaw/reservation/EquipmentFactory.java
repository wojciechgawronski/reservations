package wgaw.reservation;

import wgaw.reservation.model.Equipment;
import wgaw.reservation.model.Skates;
import wgaw.reservation.model.Ski;
import wgaw.reservation.model.Snowboard;

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

            case SKATES -> {
                return new Skates(serialNumber, condition, EquipmentType.SKATES, size);
            }

            default -> throw new IllegalArgumentException("Unsupported equipment type: " + type);
        }
    }
}
