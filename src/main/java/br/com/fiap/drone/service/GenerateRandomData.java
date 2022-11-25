package br.com.fiap.drone.service;

import br.com.fiap.drone.domain.DroneStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static br.com.fiap.drone.util.IntegerUtils.*;

@Component
public class GenerateRandomData {
    @Value("${drone.id}")
    private String idDrone; //FIXME Não carrega o valor do drone.id do application.yml

    @Value("${drone.rastreamento}")
    private boolean rastreamento;   //FIXME Não carrega o valor do drone.rastreamento do application.yml

    public DroneStatus getData() {

        return DroneStatus.builder()
                .idDrone(idDrone)
                .umidade(geneteRandNumber(0, 100))
                .temperatura(geneteRandNumber(-25, 40))
                .rastreamento(rastreamento)
                .latitude(String.valueOf(geneteRandNumber(-1000000, 1000000)))
                .longitude(String.valueOf(geneteRandNumber(-1000000, 1000000)))
                .build();
    }

}
