package com.ruda.b1;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.activation.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Boot1ApplicationTests {
	@Autowired
	private javax.sql.DataSource datasource;

	@Test
	void contextLoads () throws Exception {
		assertNotNull(datasource.getConnection());
	}

}
