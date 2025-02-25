package dev.layseiras.larussoautogroup.docs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "LaRusso Auto Group API",
                version = "1.0",
                description = "Documentação da API para gerenciamento de uma concessionária."
        )
)
public class Swagger {
}
