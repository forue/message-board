package iweb212.bbs.service;



import org.springframework.stereotype.Service;

import iweb212.bbs.model.User;
@Service("userService")
public interface UserService {
	boolean login(User users);
	void register(User user);
	void logout();
	User findUserById(int id);
	//boolean isLoggedIn(String username);
}
