package iweb212.bbs.userstate;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
/**
 * 
 *表示当前用户状态
 *实例保存在Session中
 * @author 发友
 *
 */
@Component
@SessionScope
public class UserState {
	private boolean loggedIn = false;
	private String username;
	private Integer userId;
	private int role; 
	private String displayname;
	
	public boolean isLoggiedIn() {
		return loggedIn;
	}
	public void login(Integer userId,String username,int role) {
		this.role = role;
		this.userId = userId;
		this.username = username;
		this.displayname = username;
		loggedIn = true;
	}
	public void logout() {	
		this.userId = null;
		this.username = null;
		this.displayname = null;
		this.role = 0;
		loggedIn = false;
	}
	public String getUsername() {
		return username;
	}
	public Integer getUserId() {
		return userId;
	}
	public String getDisplayname() {
		return displayname;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
}
