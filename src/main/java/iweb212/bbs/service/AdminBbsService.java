package iweb212.bbs.service;

import java.util.List;

import org.springframework.stereotype.Service;

import iweb212.bbs.model.Message;
import iweb212.bbs.model.Respond;
@Service("adminBbsService")
public interface AdminBbsService  {
	List<Message> findPageMessages(int page);
	void modifyRespond(Respond respond);
	void deleteMessage(int id);
	void deleteRespond(int id);
	//void reviewMessage(int id,String context);
	void respondMessage(Respond respond);
	Message findMessageById(int messageId);
}
