package ws.synopsis.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ws.synopsis.model.User;
import ws.synopsis.service.UserServiceImpl;

@RestController
@Controller
public class UserCreateController {

	@Autowired
	public UserServiceImpl userService;

	@PostMapping(value = "/users/register")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(user.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}
