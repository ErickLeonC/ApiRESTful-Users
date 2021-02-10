package ws.synopsis.service;

import java.util.List;

public interface ICrud<T> {
	T add(T t);

	T update(T t);

	boolean delete(long id);

	T get(long id);
	
	List<T> list();
}
