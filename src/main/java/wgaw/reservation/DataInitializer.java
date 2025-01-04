package wgaw.reservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wgaw.reservation.repository.SkiRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    private final SkiRepository skiRepository;

    public DataInitializer(SkiRepository skiRepository) {
        this.skiRepository = skiRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Ski ski1 = new Ski("ski01", "new", EquipmentType.SKI, "M");
        Ski ski2 = new Ski("ski11", "old", EquipmentType.SKI, "S");
        Ski ski3 = new Ski("ski22", "new", EquipmentType.SKI, "XL");

        System.out.println("Data initialized...");

        skiRepository.save(ski1);
        skiRepository.save(ski2);
        skiRepository.save(ski3);

        System.out.println("Data initialized: Skis added to the database.");
    }
}
