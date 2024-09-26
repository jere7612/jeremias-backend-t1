package com.example.jeremiasbackendt1.service;

import com.example.jeremiasbackendt1.dto.Auto;

import java.io.IOException;
import java.util.Optional;

public interface AutoService {
    Optional<Auto> buscarPorPlaca(String placa);
}
