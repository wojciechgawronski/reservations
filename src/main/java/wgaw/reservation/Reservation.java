package wgaw.reservation;

import java.time.LocalDateTime;

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
}
