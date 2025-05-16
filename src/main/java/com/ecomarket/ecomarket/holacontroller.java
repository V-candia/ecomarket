package com.ecomarket.ecomarket;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class holacontroller {
    @GetMapping("/hola")
    public String saludar() {
        return "¡Hola, mundo!";
    }
}
