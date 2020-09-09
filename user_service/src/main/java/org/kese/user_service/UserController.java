package org.kese.user_service;

import javax.inject.Inject;

import org.kese.messages.UserServiceProtos;
import org.kese.user_service.dao.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserDAO userDao;

	@Inject
	public UserController(UserDAO userDao) {
		this.userDao = userDao;
	}

	@GetMapping(path = "/api/user/test")
	public String getEntry() {
		return "ciao";
	}

	@PostMapping(path = "/api/user/add", consumes = "application/x-protobuf", produces = "application/x-protobuf")
	public UserServiceProtos.AddUserReply addUser(UserServiceProtos.AddUserRequest req) {
		System.currentTimeMillis();
		return UserServiceProtos.AddUserReply.newBuilder().setErrorCode(0).setMessage("Ok").build();
	}
}
