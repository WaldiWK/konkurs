package pl.kuranc.demo.konkurs.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	boolean existsByEmail(String email);
	List<User> findByEmail(String email);	
	void delete (User user);
	
}
