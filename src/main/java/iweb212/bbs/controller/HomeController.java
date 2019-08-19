package iweb212.bbs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import iweb212.bbs.model.Admin;
import iweb212.bbs.model.Message;
import iweb212.bbs.model.User;
import iweb212.bbs.service.AdminService;
import iweb212.bbs.service.UserBbsService;
import iweb212.bbs.service.UserService;
import iweb212.bbs.userstate.UserState;


@Controller
@SessionAttributes("userInfo")
public class HomeController {
	private UserService userService;
	private UserBbsService userBbsService;
	private AdminService adminService;
	private UserState userState;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setUserBbsService(UserBbsService userBbsService) {
		this.userBbsService = userBbsService;
	}
	
	@Autowired
	public void setUserState(UserState userState) {
		this.userState = userState;
	}
	
	@Autowired
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@ModelAttribute("userState")
	public UserState userState() {
		return this.userState;
	}

	@RequestMapping(value= {"/","/home"},method=RequestMethod.GET)
	public String home(
			Model model) {
		int page = 1;
		List<Message> messages = userBbsService.findPageMessages(page);
		model.addAttribute("messages",messages);
		return "home";
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.POST)
	public String userLogout(Model model) {
		userService.logout();
		return "redirect:/";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerForm() {
		return "register";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String userRegister(
			@RequestParam(value = "username")String username,
			@RequestParam(value = "password")String password,
			@RequestParam(value = "sex")String sex,
			@RequestParam(value = "displayName")String dispalyName) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setDispalyName(dispalyName);
		user.setRegisteredTime(new Date());
		userService.register(user);
		return "register-result";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String longinForm() {
		return "login";
	}
	//使用Java Validation对表单进行验证
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String userRoleLogin(
			@RequestParam("role") int role,
			@RequestParam("username") String username,
			@RequestParam("password")String password,
			Model model
			) {
		if(role == 1) {
			Admin admins=new Admin();
			admins.setName(username);
			admins.setPassword(password);
			adminService.login(admins);
			
		}else if(role == 2) {
			User users=new User();
			users.setUsername(username);
			users.setPassword(password);
			userService.login(users);
			
		}
		return "redirect:/";
	}
}
