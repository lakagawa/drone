package br.com.fiap.drone.domain;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
public class DroneStatus implements Serializable {
    private String idDrone;
    private String latitude;
    private String longitude;
    private int temperatura;
    private int umidade;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }

}
