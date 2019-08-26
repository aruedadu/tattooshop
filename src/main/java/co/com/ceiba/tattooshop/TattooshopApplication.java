package co.com.ceiba.tattooshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"co.com.ceiba.tattooshop"})
public class TattooshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TattooshopApplication.class, args);
	}

}
