package ws.synopsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ws.synopsis.model.User;

@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {
	public abstract User findById(int id);
	
}
