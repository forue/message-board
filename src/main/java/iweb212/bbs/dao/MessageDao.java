package iweb212.bbs.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import iweb212.bbs.model.Message;
@Repository
public interface MessageDao {
	List<Message> findPageMessage(int page);
	void add(Message message);
	void modify(Message message);
	void delete(int id);
	Message findMessageById(int id);
}
