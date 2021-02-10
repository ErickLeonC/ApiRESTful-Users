package ws.synopsis.service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ws.synopsis.model.User;
import ws.synopsis.repository.IUserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private IUserRepository repository;

	@Override
	public User add(User user) {
		long idUser = ThreadLocalRandom.current().nextLong(1,223372036);
		user.setId(idUser);
		return repository.save(user);
	}

	@Override
	public User update(User user) {
		User usr = repository.getOne(user.getId());
		if (usr != null) {
			return repository.save(user);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public User get(long id) {
		return repository.getOne(id);
	}

	@Override
	public List<User> list() {
		return repository.findAll();
	}



}
