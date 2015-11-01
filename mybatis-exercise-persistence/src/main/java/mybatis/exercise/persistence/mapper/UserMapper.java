package mybatis.exercise.persistence.mapper;

import java.util.List;

import mybatis.exercise.persistence.domain.User;

public interface UserMapper {

	public List<User> getUser();
	public User getUserByEmailAddress(String emailAdress);
	public Integer insertUser(User user);
}
