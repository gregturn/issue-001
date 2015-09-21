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
            Date first = new Date(Calendar.getInstance().getTime().getTime()-200000000);
            Date second = new Date(Calendar.getInstance().getTime().getTime()-100000000);
            Date third = new Date(Calendar.getInstance().getTime().getTime());
            repository.save(new Transaction(first, "First"));
            repository.save(new Transaction(second, "Second"));
            repository.save(new Transaction(third, "Third"));
        };
    }

}
