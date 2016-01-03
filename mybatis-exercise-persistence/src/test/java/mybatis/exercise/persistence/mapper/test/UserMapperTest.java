package mybatis.exercise.persistence.mapper.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.persistence.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml"})
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class UserMapperTest extends PersistenceBaseTest{

	@Autowired
	private UserMapper userMapper;
	
	
	@Test
	public void testGetUserByEmailAddress(){
		User user = userMapper.getUserByEmailAddress(TEST_EMAIL_TO_SEARCH_FOR);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testInsertUser(){
		User testUser = prepareTestUser();
		userMapper.insertUser(testUser);
		Assert.assertNotNull(testUser.getUserId());
	}
	
}
