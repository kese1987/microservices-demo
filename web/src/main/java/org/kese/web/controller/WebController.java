package org.kese.web.controller;

import javax.inject.Inject;

import org.kese.messages.UserServiceProtos;
import org.kese.messages.UserServiceProtos.AddUserReply;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

	private RestTemplate restTemplate;

	@Inject
	public WebController(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping(name = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String createUser() {

		UserServiceProtos.AddUserRequest req = UserServiceProtos.AddUserRequest.newBuilder().setEmail("someEmail")
				.setPassword("somePassword").build();

		AddUserReply result = restTemplate.postForObject("http://localhost:36365/api/user/add", req,
				UserServiceProtos.AddUserReply.class);

		return result.getMessage();
	}
}
