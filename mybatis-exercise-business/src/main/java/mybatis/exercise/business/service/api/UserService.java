package mybatis.exercise.business.service.api;

import mybatis.exercise.persistence.domain.User;

public interface UserService {

	public User insertUser(User user);
	public User getUserByEmail(String email);
}
