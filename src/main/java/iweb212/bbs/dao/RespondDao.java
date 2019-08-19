package iweb212.bbs.dao;

import org.springframework.stereotype.Repository;

import iweb212.bbs.model.Respond;
@Repository
public interface RespondDao {
	void add(Respond respond);
	void modify(Respond respond);
	void delete(int id);
}
