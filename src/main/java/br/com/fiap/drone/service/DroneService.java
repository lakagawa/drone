package br.com.fiap.drone.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DroneService implements Job {

    @Autowired
    private GenerateRandomData generateRandomData;

    @Autowired
    private SendService sendService;

    @Value("${drone.rastreamento}")
    private boolean rastreamento;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //lógica para gerar os dados :D
        var data = generateRandomData.getData();

        if(this.rastreamento) sendService.post(data);

    }
}
