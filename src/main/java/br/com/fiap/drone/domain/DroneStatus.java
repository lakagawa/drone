package br.com.fiap.drone.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class DroneStatus {
    private String idDrone;
    private String latitude;
    private String longitude;
    private int temperatura;
    private int umidade;
    private boolean rastreamento;
}
