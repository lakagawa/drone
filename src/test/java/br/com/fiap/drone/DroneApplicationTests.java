package br.com.fiap.drone;

import br.com.fiap.drone.service.GenerateRandomData;
import br.com.fiap.drone.service.SendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DroneApplicationTests {

	@Autowired
	private GenerateRandomData generateRandomData;

	@Autowired
	private SendService sendService;

	@Test
	void contextLoads() {
	}

	@Test
	void testGenerateJsonDroneStatus() {
		System.out.println("JSON: " + generateRandomData.getData().toString());
	}

	@Test
	void testSendToProducerDroneStatus() {
		var data = generateRandomData.getData();
		data.setRastreamento(true);
		sendService.post(data);
	}

}
