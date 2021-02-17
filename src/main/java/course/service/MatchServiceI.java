package course.service;

import java.util.List;

import course.model.MatchBean;

public interface MatchServiceI {

	void persist(MatchBean match);

	Object save(MatchBean match);

	MatchBean get(int pk);

	void update(MatchBean e);

	void delete(int pk);

	List<MatchBean> getAllMatch();

	void close();

}