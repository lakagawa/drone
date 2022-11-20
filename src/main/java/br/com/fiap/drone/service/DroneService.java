package br.com.fiap.drone.service;

import br.com.fiap.drone.util.IntegerUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DroneService implements Job {

    private GenerateRandomData generateRandomData = new GenerateRandomData();
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //lógica para gerar os dados :D
        var data = generateRandomData.getData();

        //TODO: montar o serviço de HTTP para enviar esses dados

    }
}
