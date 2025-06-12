package com.marketplace.product;

import com.marketplace.product.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Products microservice REST API Documentation",
				description = "TGM Products microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Atanu Chakrabarti",
						email = "atanu1996@gmail.com",
						url = "https://www.google.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.google.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "TGM Products microservice REST API Documentation",
				url = "https://www.atanu.com/tgm/products/swagger-ui.html"
		)
)
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@EnableFeignClients
public class ProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
}
