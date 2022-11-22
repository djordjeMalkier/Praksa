package common.bankarskiSistem;

import common.bankarskiSistem.model.User;
import common.bankarskiSistem.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankarskiSistem {

    private static final Logger log = LoggerFactory.getLogger(BankarskiSistem.class);

    public static void main(String[] args) {
        SpringApplication.run(BankarskiSistem.class);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            // save a few users
            repository.save(new User("1002445874466", "Pera", "Petrovic", "Ulica i broj"));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");
        };
    }

}