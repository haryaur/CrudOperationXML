package com.example.demo.configs;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Configuration
public class SerializationConfig {
	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer customXML() {
		return builder -> {
			XmlMapper xmlMapper = new XmlMapper();
			builder.configure(xmlMapper);
		};
	}

}
