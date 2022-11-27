package br.com.fiap.drone.service;

import br.com.fiap.drone.domain.DroneStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static br.com.fiap.drone.util.IntegerUtils.*;

@Component
public class GenerateRandomData {
    @Value("${drone.id}")
    private String idDrone;

    @Value("${drone.rastreamento}")
    private boolean rastreamento;

    public DroneStatus getData() {

        return DroneStatus.builder()
                .idDrone(idDrone)
                .umidade(generateRandNumber(0, 100))
                .temperatura(generateRandNumber(-25, 40))
                .rastreamento(rastreamento)
                .latitude(String.valueOf(generateRandNumber(-1000000, 1000000)))
                .longitude(String.valueOf(generateRandNumber(-1000000, 1000000)))
                .build();
    }

}
