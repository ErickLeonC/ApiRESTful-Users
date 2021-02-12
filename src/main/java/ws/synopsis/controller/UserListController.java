package ws.synopsis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ws.synopsis.model.User;
import ws.synopsis.service.UserServiceImpl;

@RestController
@Controller
public class UserListController {
	@Autowired
	public UserServiceImpl service;

	@RequestMapping(method = RequestMethod.GET, value = "/user/all")
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> list() {
		List<User> list = service.list();
		if (list == null) {
			list = new ArrayList<>();
		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}
