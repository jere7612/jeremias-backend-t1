package com.example.jeremiasbackendt1.service;
import com.example.jeremiasbackendt1.dto.Auto;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutoServiceImpl implements AutoService {

    private final ResourceLoader resourceLoader;

    public AutoServiceImpl(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
    @Override
    public Optional<Auto> buscarPorPlaca(String placa) {
        List<Auto> autos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceLoader.getResource("classpath:autos.txt").getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(";");
                if (datos.length == 7) {
                    int id = Integer.parseInt(datos[0]);
                    String marca = datos[1];
                    String modelo = datos[2];
                    String placaAuto = datos[3];
                    int nroAsientos = Integer.parseInt(datos[4]);
                    double precio = Double.parseDouble(datos[5]);
                    String color = datos[6];

                    autos.add(new Auto(id, marca, modelo, placaAuto, nroAsientos, precio, color));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return autos.stream()
                .filter(auto -> auto.placa().equalsIgnoreCase(placa))
                .findFirst();
    }


    }
