package wgaw.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import wgaw.reservation.repository.SkiRepository;

@Controller
public class SkiController {

    private final SkiRepository skiRepository;

    public SkiController(SkiRepository skiRepository) {
        this.skiRepository = skiRepository;
    }

    @GetMapping("ski")
    public String showSki(Model model) {
        var skis = skiRepository.findAll();
        model.addAttribute("ski", skis);
        return "ski";
    }
}
