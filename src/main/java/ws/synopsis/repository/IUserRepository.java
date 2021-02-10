package ws.synopsis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ws.synopsis.model.User;

public interface IUserRepository extends JpaRepository<User, Long>{

}
