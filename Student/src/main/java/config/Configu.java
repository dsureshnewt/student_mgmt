package config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class})
@ComponentScans(value = { @ComponentScan("boot.entry"),
	      @ComponentScan("Model"),
	      @ComponentScan("Controller"),
	      @ComponentScan("DAO"),
	      @ComponentScan("Service")})
public class Configu {
	    
	    @Bean
	    public InternalResourceViewResolver jspViewResolver() {
	        InternalResourceViewResolver resolver= new InternalResourceViewResolver();
	        resolver.setPrefix("/views/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }
	   
	}

