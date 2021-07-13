package conti.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"conti.dao","conti.entities"})
@EnableJpaRepositories(basePackages = { "conti.dao" })
public class ProjectContiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectContiApplication.class, args);
	}

}
