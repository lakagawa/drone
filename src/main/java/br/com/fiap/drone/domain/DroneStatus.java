package br.com.fiap.drone.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DroneStatus {

    private String idDrone;
    private String latitude;
    private String longitude;
    private int temperatura;
    private int umidade;
    private boolean rastreamento;
}
