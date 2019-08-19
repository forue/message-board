package iweb212.bbs.model;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class Message {
	private Integer id;
	private String context;
	private Date publishedTime;
	
	private User user;
	
	private Respond respond;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
	this.context = context;
	}
	public Date getPublishedTime() {
		return publishedTime;
	}
	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Respond getRespond() {
		return respond;
	}
	public void setRespond(Respond respond) {
		this.respond = respond;
	}
}
