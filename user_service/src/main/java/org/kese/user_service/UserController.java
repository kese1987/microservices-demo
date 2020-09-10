package org.kese.user_service;

import javax.inject.Inject;

import org.kese.messages.UserServiceProtos;
import org.kese.user_service.dao.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserDAO userDao;

	@Inject
	public UserController(UserDAO userDao) {
		this.userDao = userDao;
	}

	@GetMapping(path = "/test")
	public String getEntry() {
		return "ciao";
	}

	@PostMapping(path = "/add", consumes = { "application/x-protobuf" }, produces = { "application/x-protobuf" })
	public UserServiceProtos.AddUserReply addUser(@RequestBody UserServiceProtos.AddUserRequest req) {
		System.currentTimeMillis();
		return UserServiceProtos.AddUserReply.newBuilder().setErrorCode(0).setMessage(req.getEmail()).build();
	}

}
