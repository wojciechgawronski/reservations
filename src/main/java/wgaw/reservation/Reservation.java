package wgaw.reservation;

import java.time.LocalDateTime;

public class Reservation {
    Equipment equipment;
    String customerName;
    ReservationStatus reservationStatus;
    LocalDateTime startTime;
    LocalDateTime endTime;
}
