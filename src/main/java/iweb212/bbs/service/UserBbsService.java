package iweb212.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import iweb212.bbs.model.Message;
@Service("userBbsService")
public interface UserBbsService {
	List<Message> findPageMessages(int page);
	void addMessage(Message message);
	void modifyMessage(int id,String newContext);
	void deleteMessage(int id);
	Message findMessageById(int id);
}
