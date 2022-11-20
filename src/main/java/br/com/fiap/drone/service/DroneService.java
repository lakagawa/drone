package br.com.fiap.drone.service;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DroneService implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //lógica para gerar os dados :D
        System.out.println("oi");

    }
}
