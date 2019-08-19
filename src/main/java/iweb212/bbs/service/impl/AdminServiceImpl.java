package iweb212.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iweb212.bbs.dao.AdminDao;
import iweb212.bbs.model.Admin;
import iweb212.bbs.service.AdminService;
import iweb212.bbs.userstate.UserState;
@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	private UserState userState;
	private AdminDao adminDao;
	
	@Autowired
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}
	@Autowired
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	
	@Override
	public boolean login(Admin admins) {
		Admin admin= adminDao.findAdmin(admins);
		if(admin != null) {
			userState.login(admin.getId(), admin.getName(),1);
			return true;
		}
		return false;
	}

	@Override
	public void logout() {
		userState.logout();
	}

}
