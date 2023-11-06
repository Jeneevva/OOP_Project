package project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome_page";
    }
}