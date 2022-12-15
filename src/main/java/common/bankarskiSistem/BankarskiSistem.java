package common.bankarskiSistem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Users API", version = "3.0", description = "Users Information"))
public class BankarskiSistem {
    public static void main(String[] args) {
        SpringApplication.run(BankarskiSistem.class, args);
    }
}