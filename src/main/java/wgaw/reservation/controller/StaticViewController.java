package wgaw.reservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StaticViewController {

    @GetMapping("/")
    public String index(Model model)
    {
        model.addAttribute("message", "Welcome to the Reservation Application");
        return "home";
    }

    @GetMapping("/about")
    public String about()
    {
        return "about";
    }

    @GetMapping("/info")
    public String index()
    {
        return "info";
    }
}
