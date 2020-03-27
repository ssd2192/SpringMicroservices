package COMssd.services.ssdUserApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SsdUserAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsdUserAppApplication.class, args);
	}

}
