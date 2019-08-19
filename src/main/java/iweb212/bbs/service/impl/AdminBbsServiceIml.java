package iweb212.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iweb212.bbs.dao.MessageDao;
import iweb212.bbs.dao.RespondDao;
import iweb212.bbs.model.Message;
import iweb212.bbs.model.Respond;
import iweb212.bbs.service.AdminBbsService;
@Service("adminBbsService")
@Transactional
public class AdminBbsServiceIml implements AdminBbsService {
	MessageDao messageDao;
	RespondDao respondDao;
	
	@Autowired
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}
	
	@Autowired
	public void setReplyDao(RespondDao replyDao) {
		this.respondDao = replyDao;
	}
	
	@Override
	public void modifyRespond(Respond respond) {
		respondDao.modify(respond);
	}

	@Override
	public void deleteMessage(int id) {
		messageDao.delete(id);
	}

	@Override
	public void respondMessage(Respond respond) {
		respondDao.add(respond);
	}

	@Override
	public List<Message> findPageMessages(int page) {
		List<Message> messages = messageDao.findPageMessage(page);
		return messages;
	}

	@Override
	public Message findMessageById(int messageId) {
		Message message = messageDao.findMessageById(messageId);
		return message;
	}

	@Override
	public void deleteRespond(int id) {
		respondDao.delete(id);
	}

}
