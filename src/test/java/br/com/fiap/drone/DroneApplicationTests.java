package br.com.fiap.drone;

import br.com.fiap.drone.service.GenerateRandomData;
import br.com.fiap.drone.service.SendService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DroneApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testGenerateJsonDroneStatus() {
		System.out.println("TESTE json: " + new GenerateRandomData().getData().toString());
	}

	@Test
	void testSendToProducerDroneStatus() {
		var data = new GenerateRandomData().getData();
		data.setRastreamento(true);
		new SendService().post(data);
	}

}
