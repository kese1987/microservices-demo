package org.kese.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;

@RefreshScope
@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Value("${message}")
	private String message;

	@GetMapping("/")
	String root() {
		return message;
	}
}
