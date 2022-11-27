package br.com.fiap.drone.service;

import br.com.fiap.drone.domain.DroneStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static br.com.fiap.drone.util.IntegerUtils.*;

@Component
public class GenerateRandomData {
    @Value("${drone.id}")
    private String idDrone;

    public DroneStatus getData() {

        return DroneStatus.builder()
                .idDrone(idDrone)
                .umidade(generateRandNumber(0, 100))
                .temperatura(generateRandNumber(-25, 40))
                .latitude(String.valueOf(generateRandNumber(-90, 90)))
                .longitude(String.valueOf(generateRandNumber(-180, 180)))
                .build();
    }

}
