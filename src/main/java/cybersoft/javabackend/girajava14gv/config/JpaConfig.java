package cybersoft.javabackend.girajava14gv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import cybersoft.javabackend.girajava14gv.common.audit.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class JpaConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
}
