package ws.synopsis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ws.synopsis.model.User;
import ws.synopsis.repository.IUserRepository;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserRepository repository;

	@Qualifier("userRepository")
	public User addUser(User user) {
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		User usr = repository.findById(user.getId());
		if (usr != null) {
			return repository.save(user);
		} else {
			return null;
		}
	}

	@Override
	public List<User> list() {
		List<User> list = repository.findAll();
		return list;
	}

	@Override
	public User getById(int id) {
		return repository.findById(id);
	}

	@Override
	public String delete(int id) {
		User user = repository.findById(id);
		if (user != null) {
			repository.delete(user);
			return "Delete successful";
		} else
			return "Missing Id";
	}

}
