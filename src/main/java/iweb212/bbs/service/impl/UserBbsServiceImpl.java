package iweb212.bbs.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iweb212.bbs.dao.MessageDao;
import iweb212.bbs.model.Message;
import iweb212.bbs.service.UserBbsService;
@Service("userBbsService")
@Transactional
public class UserBbsServiceImpl implements UserBbsService {
	MessageDao messageDao;
	
	@Autowired
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	@Override
	public void modifyMessage(int id, String newContext) {
		Message message =new Message();
		message.setContext(newContext);
		message.setId(id);
		message.setPublishedTime(new Date());
		messageDao.modify(message);

	}

	@Override
	public void deleteMessage(int id) {
		messageDao.delete(id);
	}

	@Override
	public List<Message> findPageMessages(int page) {
		List<Message> messages = messageDao.findPageMessage(page);
		return messages;
	}

	@Override
	public void addMessage(Message message) {
		messageDao.add(message);
	}

	@Override
	public Message findMessageById(int id) {
		Message message = messageDao.findMessageById(id);
		return message;
	}

}
