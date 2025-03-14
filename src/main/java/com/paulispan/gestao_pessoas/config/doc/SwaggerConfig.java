package com.paulispan.gestao_pessoas.config.doc;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gestão de Pessoas")
                        .contact(new Contact().email("mello.developer797@gmail.com").name("Samuel Mello"))
                        .description(
                                "Uma API para gerenciar os Recursos Humanos de uma empresa.Nos permite gerenciar recursos como:\n" +
                                        " 1. Dados pessoais e informações de contrato do colaborador;\n" +
                                        " 2. Controle de solicitações e requisições de uniforme e EPIs;\n" +
                                        " 3. Controle do estoque e do custo com uniformes e EPIs;\n")
                        .version("0.0.1")
                );
    }
}
