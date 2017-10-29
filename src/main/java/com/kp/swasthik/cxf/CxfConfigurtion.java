package com.kp.swasthik.cxf;

import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharingFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;

@Configuration
@ConfigurationProperties(prefix="cxf.swagger")
public class CxfConfigurtion {

	private String version;
	private String title;
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Bean
	public JacksonJaxbJsonProvider jaxbJsonProvider() {
		return new JacksonJaxbJsonProvider();
	}
	
	@Bean
	public Swagger2Feature swagger2Feature() {
		Swagger2Feature feature = new Swagger2Feature();
		feature.setVersion(getVersion());
		feature.setTitle(getTitle());
		return feature;
	}
	
	
	@Bean
	public CrossOriginResourceSharingFilter crosFilter() {
		return new CrossOriginResourceSharingFilter();
	}
	
	@Bean
	public WebMvcConfigurer crosConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/services/**").allowedOrigins("http://localhost:8080");
				super.addCorsMappings(registry);
			}
		};
	}
}
