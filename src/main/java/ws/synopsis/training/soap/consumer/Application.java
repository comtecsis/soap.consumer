package ws.synopsis.training.soap.consumer;

import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.com.synopsis.client.soap.WsCountryClient;
import ws.synopsis.training.soap.consumer.config.WsConfig;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private WsCountryClient client;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String name = "Spain";
		GetCountryResponse response = client.getCountry(name);
		System.out.println(response.getCountry().getCapital());
	}
}
