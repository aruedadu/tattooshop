package co.com.ceiba.tattooshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@ComponentScan({"co.com.ceiba.tattooshop"})
@EnableJpaRepositories("co.com.ceiba.tattooshop.infraestructure.db.jpa")
@EntityScan("co.com.ceiba.tattooshop.infraestructure.entity")
public class TattooshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(TattooshopApplication.class, args);
	}

}
