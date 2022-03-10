package br.com.securityoauth2.securityoauth2;

import br.com.securityoauth2.securityoauth2.config.SecurityProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(SecurityOauth2Application.class, args);
	}

}
