package cybersoft.javabackend.girajava14gv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
				.info(new Info().title("Gira Application")
	              .description("Spring shop sample application")
	              .version("v1.0")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
			    .externalDocs(new ExternalDocumentation()
	              .description("SpringShop Wiki Documentation")
	              .url("https://springshop.wiki.github.org/docs"));

	}
}
