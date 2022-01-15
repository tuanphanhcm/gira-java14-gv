package cybersoft.javabackend.girajava14gv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityScheme.Type;

@Configuration
public class OpenApiConfiguration {
	
	@Bean
	public OpenAPI getOpenApi() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("bearerAuth",
						new SecurityScheme().type(Type.HTTP).scheme("bearer")))
				.info(new Info()
					.title("Gira Application")
					.description("Gira Application for Education Purpose")
					.version("v1.0")
					.license(new License().name("NO LICENSE").url("http://tuanphan.dev"))
					.contact(new Contact()
	            		  .email("contact@tuanphan.dev")
	            		  .name("Phan Thanh Tuan")
	            		  .url("https://tuanphan.dev")))
			    .externalDocs(new ExternalDocumentation()
	              .description("Spring Documentation")
	              .url("https://docs.spring.io/spring-framework/docs/current/reference/html/"));

	}
}
