package wgaw.reservation.model;

import jakarta.persistence.*;
import wgaw.reservation.EquipmentType;

@Entity
@Table(name = "ski")
public class Ski extends Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size")
    private String size;

    @Column(name = "conditions")
    private String conditions;

    @Column(name = "equipment_type")
    @Enumerated(EnumType.STRING)
    private EquipmentType equipmentType;

    @Override
    public String getSerialNumber() { return serialNumber; }

    @Column(name = "serial_number")
    private String serialNumber;

    // Konstruktor bezargumentowy (wymagany przez Hibernate)
    public Ski() {
        super("", "", EquipmentType.SKI); // Wywołanie konstruktora klasy nadrzędnej
        this.size = "";
        this.conditions = "";
        this.equipmentType = EquipmentType.SKI;
    }

    public Ski(String serialNumber,
               String conditions,
               EquipmentType equipmentType,
               String size
               ) {
        super(serialNumber,conditions, equipmentType);
        this.size = size;
        this.conditions = conditions;
        this.equipmentType = equipmentType;
        this.serialNumber = serialNumber;
    }

    public String getSize() {
        return size;
    }

    public Long getId() { return id; }

    @Override
    public String getDetails() {
        return "Ski details: Serial: "+getSerialNumber()+" ,conditions: "+getConditions()+", size: "+getSize();
    }

    @Override
    public String getConditions() { return conditions; }
}