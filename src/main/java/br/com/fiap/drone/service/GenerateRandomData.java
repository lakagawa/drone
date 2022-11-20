package br.com.fiap.drone.service;

import br.com.fiap.drone.domain.DroneStatus;
import org.springframework.beans.factory.annotation.Value;

import static br.com.fiap.drone.util.IntegerUtils.*;


public class GenerateRandomData {
    @Value("${id_drone}")
    private String idDrone;

    public DroneStatus getData() {

        return DroneStatus.builder()
                .idDrone(idDrone)
                .umidade(geneteRandNumber(0, 100))
                .temperatura(geneteRandNumber(-25, 40))
                .rastreamento(geneteRandNumber(0,1) == 1)
                .latitude("")
                .longitude("")
                .build();
    }
}
