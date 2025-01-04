# The project

### Requirements
- required at least 10 classes/interfaces/enums
- must have abstract class, interface, enum, final class
- must contain inheritance
- must contain unit tests
- must contain test in main method
- must implement at least 2 design pattersns
- must follow SOLID, KISS, YAGNI, DRY

---

# Idea: Sports Equipment Rental Reservation System
A system for managing reservations and rentals of sports equipment, such as skis, snowboards, ice skates, etc. It includes support for different types of users (customers and administrators) and diverse rules for handling reservations.

---

## Key Features

### **Abstract Class: `Equipment`**
- Represents general characteristics of equipment (e.g., serial number, condition).

### **Interface: `Reservable`**
- Defines the behavior of reservable objects (e.g., `reserve()`, `cancelReservation()`).

### **Enum: `EquipmentType`**
- Specifies equipment types (e.g., `SKI`, `SNOWBOARD`, `SKATES`).

### **Final Class: `DatabaseConnection`**
- Manages a single instance of the database connection (Singleton pattern).

### **Inheritance**
- Equipment classes (e.g., `Ski`, `Snowboard`) inherit from the abstract `Equipment` class.

### **Design Patterns**
- **Singleton**: For managing the database connection (`DatabaseConnection`).
- **Factory**: For creating equipment objects based on type (`EquipmentFactory`).

### **SOLID Principles**
- Each class has a single responsibility (e.g., `ReservationManager` handles reservations).

### **Unit Tests**
- Test methods for reservation creation, cancellation, and data validation.

### **Main Testing Method**
- Simulates rental processes, including reservation, return, and cancellation.

### **YAGNI/KISS/DRY Principles**
- Implements only essential features, avoids overengineering, and ensures reusable code.

---

#### Podsumowanie:
- Baza danych: post Zacznij od H2, potem PostgreSQL/MySQL dla zaawansowanych wymagań.
- postresql, seedery
- IntelliJ Edu: Wystarczający dla nauki, ale wymaga więcej ręcznej konfiguracji.
- IntelliJ Ultimate: Lepszy wybór dla wygody i szybkości pracy.

#  Pomysł: System rezerwacji wypożyczalni sprzętu sportowego
system obsługujący rezerwację i zarządzanie wypożyczaniem sprzętu sportowego, np. nart, snowboardów, łyżew itp. System uwzględnia różne typy użytkowników (klienci i administratorzy) oraz różnorodne zasady dotyczące rezerwacji.

## Kluczowe elementy

### Abstrakcyjna klasa: Equipment -
- reprezentuje ogólne cechy sprzętu (np. numer seryjny, stan).

### Interfejs: Reservable
- definiuje zachowanie obiektów możliwych do rezerwacji (np. reserve(), cancelReservation()).

### Enum: EquipmentType
- określa typy sprzętu (np. NARTY, SNOWBOARD, LYZWY).

### Final Class: DatabaseConnection
- zarządza jedną instancją połączenia z bazą danych (Singleton).

### Dziedziczenie
- Klasy sprzętu (np. Ski, Snowboard) dziedziczą po abstrakcyjnej klasie Equipment.

### Wzorce projektowe:
- Singleton: Zarządzanie połączeniem z bazą danych (DatabaseConnection).
- Factory: Tworzenie obiektów sprzętu w zależności od typu (EquipmentFactory).

### SOLID
- Każda klasa odpowiada za jedną odpowiedzialność (np. ReservationManager obsługuje rezerwacje).

### Testy jednostkowe
- Testowanie metod rezerwacji, anulowania i poprawności danych.

### Główna metoda testująca:
- Symulacja wypożyczenia, zwrotu i anulowania rezerwacji.

### YAGNI/KISS/DRY
- Tylko kluczowe funkcje, bez nadmiaru kodu, z możliwością rozszerzenia.

---

#### Summary:
- **Database**: Start with H2 for simplicity, then move to PostgreSQL/MySQL for advanced requirements.
- **PostgreSQL, Seeders**: Use for initializing database data.
- **IntelliJ Edu**: Sufficient for learning but requires more manual setup.
- **IntelliJ Ultimate**: A better choice for convenience and faster development.

---

```bash
mvn test;
mvn -Dtest=ReservationTest test;
mvn -Dtest=ReservationTest#testGetAllReservations test

```

```bash
sudo systemctl start postgresql
sudo -i -u postgres;  
psql;  # konsola postgres
CREATE USER user WITH PASSWORD 'tajne';
CREATE DATABASE db OWNER user;
GRANT ALL PRIVILEGES ON DATABASE db TO app_user;
\q # zakończ sesje
exit # wyjdz w konta postgres
sudo systemctl restart postgresql

sudo apt install postgresql-client
psql -h localhost -U user -d db
```

Testy jednostkowe: Testowanie metod rezerwacji, anulowania i poprawności danych
reserve() i cancelReservation() (czy zmieniają stan poprawnie).
EquipmentFactory.createEquipment() (czy tworzy odpowiedni typ sprzętu).
