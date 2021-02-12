package ws.synopsis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.exception.ModeloNotFoundException;
import ws.synopsis.service.UserServiceImpl;

@RestController
@Controller
public class UserDeleteController {
	@Autowired
	public UserServiceImpl service;

	@DeleteMapping(value = "/users/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable("id")@RequestBody int id) {
		if (service.getById(id) == null) {
			throw new ModeloNotFoundException("ID not found: " + id);
		} else {
			service.delete(id);
		}
	}

}
