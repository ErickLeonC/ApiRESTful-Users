package ws.synopsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.exception.ModeloNotFoundException;
import ws.synopsis.model.User;

import ws.synopsis.service.UserServiceImpl;

@RestController
@Controller
public class UserUpdateController {
	@Autowired
	public UserServiceImpl service;

	@RequestMapping(method = RequestMethod.PUT, value = "/user/update")
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User _usr = service.update(user);
		if (_usr == null) {
			throw new ModeloNotFoundException("ID not found: " + _usr.getId());
		}
		return new ResponseEntity<>(_usr, HttpStatus.OK);
	}
}
