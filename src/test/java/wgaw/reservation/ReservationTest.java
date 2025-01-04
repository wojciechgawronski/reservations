package wgaw.reservation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import wgaw.reservation.model.Skates;
import wgaw.reservation.model.Ski;
import wgaw.reservation.model.Snowboard;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    private List<Equipment> allEquipmnet;
    private List<Reservation> reservations;

    @BeforeEach
    void setUp() {
        allEquipmnet = new ArrayList<>();
        reservations = new ArrayList<>();

        allEquipmnet.add(EquipmentFactory.createEquipment(EquipmentType.SKI, "SKI123", "new", "m"));
        allEquipmnet.add(EquipmentFactory.createEquipment(EquipmentType.SNOWBOARD, "snow123", "new", "m"));
        allEquipmnet.add(EquipmentFactory.createEquipment(EquipmentType.SKI, "SKI123", "new", "m"));

        reservations.add(new Reservation(allEquipmnet.get(0), "john", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(3), ReservationStatus.ACTIVE));
        reservations.add(new Reservation(allEquipmnet.get(1), "jane", LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(2).plusHours(3), ReservationStatus.ACTIVE));
    }

    @Test
    void testGetAllReservations() {
        LocalDateTime startTime = LocalDateTime.now().plusDays(1).plusHours(4);
        LocalDateTime endTime = startTime.plusHours(2);

        List<Equipment> availableEquipments = Reservation.getAvailableEquipment(allEquipmnet, reservations, startTime, endTime);

        assertEquals(allEquipmnet.size(), availableEquipments.size());
        assertEquals(3, availableEquipments.size());
    }


    @Test
    void testReservationCreation() {
        LocalDateTime startTime = LocalDateTime.now().plusDays(1).plusHours(1);
        LocalDateTime endTime = startTime.plusHours(2);

        Equipment equipment = allEquipmnet.get(2);
        Reservation newReservation = new Reservation(equipment, "john", startTime, endTime, ReservationStatus.ACTIVE);

        reservations.add(newReservation);

        assertTrue(reservations.contains(newReservation));
        assertEquals("john", newReservation.getCustomerName());
        assertEquals(reservations.get(2), newReservation);
    }

    @Test
    void testCancelReservation() {
        Reservation reservation = reservations.get(0);
        reservation.cancel();

        assertEquals(ReservationStatus.CANCELLED, reservation.getStatus());
    }

    @Test
    void testIsEquipmentAvailable() {
        Equipment equipment = allEquipmnet.get(0);
        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = startTime.plusHours(2);

        boolean isAvailable = Reservation.isEquipmentAvailable(equipment, startTime, endTime, reservations);
        assertFalse(isAvailable, "Equipment should not be available during this time.");
    }

    @Test
    void testReserveMethod() {
        Equipment equipment = allEquipmnet.get(1); // Snowboard
        LocalDateTime startTime = LocalDateTime.now().plusDays(2);
        LocalDateTime endTime = startTime.plusHours(3);

        Reservation reservation = new Reservation(equipment, "Alice Johnson", startTime, endTime, ReservationStatus.ACTIVE);

        assertEquals(ReservationStatus.ACTIVE, reservation.getStatus(), "Reservation status should be ACTIVE after reserving.");
        assertNotNull(reservation.getStartTime(), "Start time should not be null.");
        assertNotNull(reservation.getEndTime(), "End time should not be null.");
    }

    @Test
    void testEquipmentFactoryCreatesCorrectEquipment() {
        Equipment ski = EquipmentFactory.createEquipment(EquipmentType.SKI, "SN123", "New", "M");
        Equipment snowboard = EquipmentFactory.createEquipment(EquipmentType.SNOWBOARD, "SB456", "Used", "L");
        Equipment skates = EquipmentFactory.createEquipment(EquipmentType.SKATES, "SK789", "Like New", "XL");

        assertTrue(ski instanceof Ski, "Factory should create a Ski instance.");
        assertEquals("SN123", ski.getSerialNumber(), "Serial number should match.");

        assertTrue(snowboard instanceof Snowboard, "Factory should create a Snowboard instance.");
        assertEquals("SB456", snowboard.getSerialNumber(), "Serial number should match.");

        assertTrue(skates instanceof Skates, "Factory should create a Skates instance.");
        assertEquals("SK789", skates.getSerialNumber(), "Serial number should match.");
    }
}