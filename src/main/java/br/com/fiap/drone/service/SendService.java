package br.com.fiap.drone.service;

import br.com.fiap.drone.domain.DroneStatus;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class SendService {

    @Value("${producer.url}")
    private String url;

    public void post(DroneStatus droneStatus) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()){

            HttpPost httpPost = new HttpPost(this.url);
            httpPost.setEntity(new StringEntity(droneStatus.toString()));
            httpPost.setHeader("accept", String.valueOf(ContentType.APPLICATION_JSON));
            httpPost.setHeader("content-type", String.valueOf(ContentType.APPLICATION_JSON));
            httpClient.execute(httpPost);

            log.info(droneStatus.toString());
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

}
