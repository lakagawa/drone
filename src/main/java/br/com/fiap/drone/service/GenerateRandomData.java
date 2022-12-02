package br.com.fiap.drone.service;

import br.com.fiap.drone.domain.DroneStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static br.com.fiap.drone.util.RandomValueUtils.*;

@Component
public class GenerateRandomData {
    @Value("${drone.id}")
    private String idDrone;

    public DroneStatus getData() {

        return DroneStatus.builder()
                .idDrone(idDrone)
                .umidade(generateRandNumber(0, 100))
                .temperatura(generateRandNumber(-25, 40))
                .latitude(generateRandNumber(-90.0, 90.0))
                .longitude(generateRandNumber(-180.0, 180.0))
                .build();
    }

}
