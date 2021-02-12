package ws.synopsis.service;

import java.util.List;

import ws.synopsis.model.User;

public interface UserService {

	public abstract User addUser(User user);

	public abstract List<User> list();

	public abstract User getById(int id);

	public abstract String delete(int id);

	public abstract User update(User user);

}
