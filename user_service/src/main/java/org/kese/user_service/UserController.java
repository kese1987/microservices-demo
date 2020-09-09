package org.kese.user_service;

import javax.inject.Inject;

import org.kese.user_service.dao.UserDAO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private UserDAO userDao;

	@Inject
	public UserController(UserDAO userDao) {
		this.userDao = userDao;
	}

	@PostMapping(name = "add")
	public void addUser() {

	}
}
