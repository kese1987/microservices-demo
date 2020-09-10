package org.kese.web;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfiguration {

	@Bean
	ProtobufHttpMessageConverter protobufHttpMessageConverter() {
		return new ProtobufHttpMessageConverter();
	}

	@Bean
	@LoadBalanced
	RestTemplate protoBufRestTemplate(ProtobufHttpMessageConverter protoBufConverter) {
		RestTemplate template = new RestTemplate();
		template.getMessageConverters().add(protoBufConverter);
		return template;
	}

}
