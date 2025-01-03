package wgaw.reservation;

import java.time.LocalDateTime;

public class Reservation {
    Equipment equipment;
    String customerName;
    private ReservationStatus status;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }
}
