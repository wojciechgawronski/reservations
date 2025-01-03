package wgaw.reservation;

import java.time.LocalDateTime;

public interface Reservable {
    boolean reserve(String customerName, LocalDateTime startDate, LocalDateTime endDate);
    boolean cancelReservation();
    boolean isAvailable(LocalDateTime startDate, LocalDateTime endDate);
}
