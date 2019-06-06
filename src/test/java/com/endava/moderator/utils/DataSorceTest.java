package com.endava.moderator.utils;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.endava.moderator.ServiceModeratorApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServiceModeratorApplication.class})
public class DataSorceTest {
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testDataSource() {
		assertNotNull(dataSource);
	}
}
