package ws.synopsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.exception.ModeloNotFoundException;
import ws.synopsis.model.User;
import ws.synopsis.service.UserServiceImpl;

@RestController
@Controller
public class UserGetController {
	@Autowired
	public UserServiceImpl service;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id")@RequestBody int id) {
		User user = service.getById(id);
		if (user == null) {
			throw new ModeloNotFoundException("ID not found: " + id);
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

}
