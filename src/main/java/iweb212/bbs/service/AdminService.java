package iweb212.bbs.service;

import org.springframework.stereotype.Service;

import iweb212.bbs.model.Admin;

@Service("adminService")
public interface AdminService {
	boolean login(Admin admins);
	void logout();
	//boolean isLoggedIn(String name);
}
