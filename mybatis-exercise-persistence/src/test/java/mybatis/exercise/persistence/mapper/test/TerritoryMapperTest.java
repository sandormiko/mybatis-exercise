package mybatis.exercise.persistence.mapper.test;

import mybatis.exercise.persistence.domain.Territory;
import mybatis.exercise.persistence.mapper.TerritoryMapper;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class TerritoryMapperTest extends PersistenceBaseTest{

	@Autowired
	private TerritoryMapper territoryMapper;
	
	@Test
	public void testgetTerritoryById(){
		Territory territory = territoryMapper.getTerritoryById(ID_HUNGARY);
		Assert.assertNotNull(territory);
	}
}
