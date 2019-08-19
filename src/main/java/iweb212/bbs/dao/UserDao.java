package iweb212.bbs.dao;

import org.springframework.stereotype.Repository;

import iweb212.bbs.model.User;
@Repository
public interface UserDao {
	
	User findUser(User users);

	void addUser(User user);

	User findUserById(int id);
}
