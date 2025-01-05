package wgaw.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import wgaw.reservation.model.Ski;
import wgaw.reservation.repository.SkiRepository;
import java.util.List;

@Controller
public class SkiController {

    private final SkiRepository skiRepository;

    public SkiController(SkiRepository skiRepository) {
        this.skiRepository = skiRepository;
    }

    @GetMapping("ski")
    public String showSki(Model model) {
        var skis = skiRepository.findAllOrderByIdAsc();
        model.addAttribute("ski", skis);
        return "ski/ski";
    }

    @PostMapping("/ski")
    public String saveSki(@ModelAttribute("ski") Ski ski) {
        skiRepository.save(ski);
        return "redirect:/ski";
    }

    @GetMapping("ski/new")
    public String showNewSki(Model model) {
        model.addAttribute("ski", new Ski());
        return "ski/form";
    }

    @GetMapping("/ski/edit/{id}")
    public String showEditSki(@PathVariable Long id, Model model) {
        Ski ski = skiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ski id: "+id));
        model.addAttribute("ski", ski);
        return "ski/form";
    }

    @PostMapping("/ski/update/{id}")
    public String showUpdateSki(@PathVariable Long id, @ModelAttribute Ski updatedSki) {
        var existingSki = skiRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ski not found"));
        existingSki.setSerialNumber(updatedSki.getSerialNumber());
        existingSki.setConditions(updatedSki.getConditions());
        existingSki.setSize(updatedSki.getSize());
        skiRepository.save(existingSki);

        return "redirect:/ski";
    }

    @GetMapping("/ski/delete/{id}")
    public String deleteSki(@PathVariable Long id) {
        skiRepository.deleteById(id);
        return "redirect:/ski";
    }

    @GetMapping("/ski/debug")
    @ResponseBody
    public List<Ski> debugSki() {
        return skiRepository.findAll();
    }
}
