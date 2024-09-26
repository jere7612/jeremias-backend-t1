package com.example.jeremiasbackendt1.controller;

import com.example.jeremiasbackendt1.dto.Auto;
import com.example.jeremiasbackendt1.service.AutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auto")


public class AutoController {
    private final AutoService autoService;

    public AutoController(AutoService autoService) {
        this.autoService = autoService;
    }
    @GetMapping("/placa/{placa}")
    public ResponseEntity<Auto> buscarPorPlaca(@PathVariable String placa) {
        return autoService.buscarPorPlaca(placa)
                .map(auto -> ResponseEntity.ok(auto))
                .orElse(ResponseEntity.notFound().build());
    }




}
