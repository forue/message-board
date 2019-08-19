package iweb212.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iweb212.bbs.dao.UserDao;
import iweb212.bbs.model.User;
import iweb212.bbs.service.UserService;
import iweb212.bbs.userstate.UserState;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private UserState userState;
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	
	@Override
	public boolean login(User users) {
		User user = userDao.findUser(users);
		if(user != null) {
			userState.login(user.getId(), user.getUsername(),2);
			return true;
		}
		return false;
	}

	@Override
	public void logout() {
		userState.logout();
	}

	@Override
	public void register(User user) {
		userDao.addUser(user);
	}

	@Override
	public User findUserById(int id) {
		User user = userDao.findUserById(id);
		return user;
	}

}
