package iweb212.bbs.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Admin {
	private Integer id;
	private String name;
	private String password;
	private List<Respond> responds;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Respond> getRespond() {
		return responds;
	}
	public void setRespond(List<Respond> respond) {
		this.responds = respond;
	}
	
		
}
