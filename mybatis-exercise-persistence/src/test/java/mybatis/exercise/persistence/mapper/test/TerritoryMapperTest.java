package mybatis.exercise.persistence.mapper.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.mapper.TerritoryMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:persistence-context.xml" })
public class TerritoryMapperTest extends PersistenceBaseTest{

	@Autowired
	private TerritoryMapper territoryMapper;
	
	@Test
	public void testgetTerritoryById(){
		Territory territory = territoryMapper.getTerritoryById(ID_HUNGARY);
		Assert.assertNotNull(territory);
	}
}
