package com.tutego.date4u;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.*;

//@SpringBootTest( properties = { "spring.shell.interactive.enabled=false"})
@SpringBootTest
@TestPropertySource( properties = {"spring.shell.interactive.enabled=false"},
					 locations = { "classpath:test.properties"})
class Date4uApplicationTests {


	@Value( "${date4u.filesystem.minimum-free-disk-space}")
	private long minimumFreeDiskSpace;

	@Test
	void contextLoads() {
	}


	@Test
	void checkFreeSpace() {

		assertThat(minimumFreeDiskSpace).isEqualTo(200000L);
	}

}
