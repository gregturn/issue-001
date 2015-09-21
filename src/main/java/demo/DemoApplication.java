package demo;

import java.sql.Date;
import java.util.Calendar;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(MyRepository repository) {
        return evt -> {
            Date now = new Date(Calendar.getInstance().getTime().getTime());
            repository.save(new Transaction(now, now));
            repository.save(new Transaction(now, now));
            repository.save(new Transaction(now, now));
        };
    }

}
