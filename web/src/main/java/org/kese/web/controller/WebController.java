package org.kese.web.controller;

import javax.inject.Inject;

import org.kese.messages.UserServiceProtos;
import org.kese.messages.UserServiceProtos.AddUserReply;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WebController {

	private RestTemplate protoTemplate;

	@Inject
	public WebController(RestTemplate protoTemplate) {
		this.protoTemplate = protoTemplate;
	}

	@GetMapping(name = "/", produces = MediaType.TEXT_HTML_VALUE)
	public String createUser() {
		UserServiceProtos.AddUserRequest req = UserServiceProtos.AddUserRequest.newBuilder().setEmail("erika")
				.setPassword("somePassword").build();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/x-protobuf");
		HttpEntity<UserServiceProtos.AddUserRequest> entity = new HttpEntity<UserServiceProtos.AddUserRequest>(req,
				headers);

		ResponseEntity<UserServiceProtos.AddUserReply> result = protoTemplate
				.postForEntity("http://gateway-service/api/user/add", entity, UserServiceProtos.AddUserReply.class);

		AddUserReply reply = result.getBody();
		return reply.getMessage();
	}
}
