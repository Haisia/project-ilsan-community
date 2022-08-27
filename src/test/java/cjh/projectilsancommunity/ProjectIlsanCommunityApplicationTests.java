package cjh.projectilsancommunity;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectIlsanCommunityApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private SqlSessionTemplate sqlSession;

}
