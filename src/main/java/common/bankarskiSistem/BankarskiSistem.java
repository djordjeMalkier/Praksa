package common.bankarskiSistem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Bankarski sistem API", version = "3.0", description = "Bankarski sistem"))
public class BankarskiSistem {
    public static void main(String[] args) {
        SpringApplication.run(BankarskiSistem.class, args);
    }
}