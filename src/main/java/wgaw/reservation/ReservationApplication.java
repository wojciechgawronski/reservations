package wgaw.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {

        SpringApplication.run(ReservationApplication.class, args);

        // Create equipment using a factory
        Equipment ski1 = EquipmentFactory.createEquipment(
            EquipmentType.SKI,
            "ski11",
            "New",
            "M"
        );

        Equipment ski2 = EquipmentFactory.createEquipment(
            EquipmentType.SKI,
                "ski22",
                "Used, Scratched",
                "Small"
        );

        Equipment snowboard1 = EquipmentFactory.createEquipment(
            EquipmentType.SNOWBOARD,
                "snow11",
                "new",
                "x-large"
        );

        System.out.println(ski1.getDetails());
        System.out.println(ski2.getDetails());
        System.out.println(snowboard1.getDetails());

    }

}
