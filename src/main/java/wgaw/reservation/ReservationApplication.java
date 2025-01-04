package wgaw.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import wgaw.reservation.model.Equipment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

        System.out.println();

        List<Equipment> allEquipment = new ArrayList<>();
        allEquipment.add(ski1);
        allEquipment.add(ski2);
        allEquipment.add(snowboard1);

        List<Reservation> reservations = new ArrayList<>();
        LocalDateTime checkStartTime = LocalDateTime.now();
        LocalDateTime checkEndTime = checkStartTime.plusDays(3).plusHours(2);

        List<Equipment> availableEquipment = Reservation.getAvailableEquipment(allEquipment, reservations,checkStartTime, checkEndTime);

        if (!availableEquipment.isEmpty()) {
            Equipment selectedEquipment = availableEquipment.get(0);
            Reservation newReservation = new Reservation(selectedEquipment, "woj", checkStartTime, checkEndTime, ReservationStatus.ACTIVE);
            reservations.add(newReservation);
            System.out.println("Successfull reservation for: "+ selectedEquipment.getSerialNumber());
        } else {
            System.out.println("No equipment available for the specified time.");
        }

        // reservation equipment on two days
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = LocalDateTime.now().plusDays(3);
        Reservation skiReservation1 = new Reservation(ski1, "john doe", startTime, endTime, ReservationStatus.ACTIVE );
        Reservation snowboardReservation1 = new Reservation(snowboard1, "john doe", startTime, endTime, ReservationStatus.ACTIVE );
        Reservation snowboardReservation2 = new Reservation(snowboard1, "jane doe", startTime, endTime, ReservationStatus.ACTIVE );

        skiReservation1.getDetails();
        snowboardReservation1.getDetails();

        reservations.add(skiReservation1);
        reservations.add(snowboardReservation1);
        reservations.add(snowboardReservation2);

        // cancel one reservation
        skiReservation1.cancel();

        // show all reservations
        System.out.println("\nAll reservations:");
        int index = 1;
        for (Reservation reservation : reservations) {
            System.out.println(index+".:");
            reservation.getDetails();
            index++;
        }

        // show active reservations
        System.out.println("\nActive reservations:");
        List<Reservation> reservationsActive = reservations.stream()
                .filter(reservation -> reservation.getStatus() == ReservationStatus.ACTIVE)
                .toList();

        index = 1;
        for (Reservation reservation : reservationsActive) {
            System.out.println(index+".:");
            reservation.getDetails();
            index++;
        }

        // finalize reservation
        snowboardReservation1.setStatus(ReservationStatus.COMPLETED);
        System.out.println("Completed reservations:");
        List<Reservation> reservationsCompleted = reservations.stream()
                .filter(reservation -> reservation.getStatus() == ReservationStatus.COMPLETED)
                .toList();
        index = 1;
        for (Reservation reservation : reservationsCompleted) {
            System.out.println(index+".:");
            reservation.getDetails();
        }
    }

}
