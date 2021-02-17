package course.service;

import course.model.MatchStatusBean;

public interface MatchStatusServiceI {

	MatchStatusBean get(int pk);

	void close();

}