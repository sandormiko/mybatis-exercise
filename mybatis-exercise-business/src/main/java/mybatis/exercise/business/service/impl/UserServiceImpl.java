package mybatis.exercise.business.service.impl;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.persistence.mapper.UserMapper;
import mybatis.exercise.business.rule.validation.api.Validator;
import mybatis.exercise.business.service.api.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	private Validator<User> userValidator;
	
	@Autowired
	public UserServiceImpl(UserMapper aUserMapper,
			@Qualifier(value = "userValidator") Validator<User> aUserValidator) {
		this.userMapper = aUserMapper;
		this.userValidator = aUserValidator;
	}
	
	@Transactional
	public User insertUser(User user) {
		userValidator.validate(user);
		userMapper.insertUser(user);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User userByEmail = userMapper.getUserByEmailAddress(email);
		return userByEmail;
	}

}
