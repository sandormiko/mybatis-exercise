package mybatis.exercise.persistence.mapper.test;

import mybatis.exercise.persistence.domain.User;
import mybatis.exercise.persistence.mapper.UserMapper;

import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml"})
public class UserMapperTest{

	private static final String EMAIL_TO_SEARCH_FOR = "jakab@gipsz.hu";
	
	@Autowired
	private UserMapper userMapper;
	private User testUser;
	
	@Before
	public void init(){
		LocalDate bd = new LocalDate(1977,12,12);
		testUser = new User("Jakab","Gipsz","unit@teszt.hu",bd.toDate());
	}
	
	@Test
	public void testGetUserByEmailAddress(){
		User user = userMapper.getUserByEmailAddress(EMAIL_TO_SEARCH_FOR);
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testInsertUser(){
		userMapper.insertUser(testUser);
		Assert.assertNotNull(testUser.getUserId());
	}
	
}
