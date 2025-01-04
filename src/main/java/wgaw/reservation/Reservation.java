package wgaw.reservation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private final Equipment equipment;
    private final String customerName;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private ReservationStatus status;

    public Reservation(
            Equipment equipment,
            String customerName,
            LocalDateTime startTime,
            LocalDateTime endTime,
            ReservationStatus status
    ) {
        this.equipment = equipment;
        this.customerName = customerName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public void getDetails() {
        System.out.println("Reservation Details: Customer: " + customerName
                + ", Start: " + startTime
                + ", End: " + endTime
                + ", Status: " + status
                + ", Equipment: " + equipment.getEquipmentType() + ", SN: "+equipment.getSerialNumber()
        );
    }

    public String getCustomerName() {
        return customerName;
    }

    public void cancel() {
        this.status = ReservationStatus.CANCELLED;
    }

    public void complete() {
        this.status = ReservationStatus.COMPLETED;
    }

    public boolean isCompleted(){
        return this.status == ReservationStatus.COMPLETED;
    }

    public boolean isActive() {
        return status == ReservationStatus.ACTIVE;
    }

    public static boolean isEquipmentAvailable(Equipment equipment, LocalDateTime startTime, LocalDateTime endTime, List<Reservation> reservations) {
        for (Reservation reservation : reservations) {
            if (reservation.getEquipment().equals(equipment)) {
                // checking if the time is matchingg with existing reservation
                if ((startTime.isBefore(reservation.getEndTime()) && startTime.isAfter(reservation.getStartTime())) ||
                        (endTime.isBefore(reservation.getEndTime()) && endTime.isAfter(reservation.getStartTime())) ||
                        (startTime.isBefore(reservation.getStartTime()) && endTime.isAfter(reservation.getEndTime()))) {
                    return false; // unfortunately equipment is already reserved these time
                }

            }
        }
        return true;
    }

    public static List<Equipment> getAvailableEquipment(List<Equipment> allEquipment, List<Reservation> reservations, LocalDateTime startTime, LocalDateTime endTime)
    {
        List<Equipment> avaiableEquipment = new ArrayList<>();
        for (Equipment equipment : allEquipment) {
            boolean isAvailable = isEquipmentAvailable(equipment, startTime, endTime, reservations);
            if (isAvailable) {
                avaiableEquipment.add(equipment);
            }
        }
        return avaiableEquipment;
    }
}
