package ws.synopsis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "ws.synopsis" })
public class ApiRestTzApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestTzApplication.class, args);
	}

}
