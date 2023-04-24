package com.tutego.date4u;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.io.UncheckedIOException;
import java.nio.file.Paths;
import java.util.UUID;

public class FileSystemTests {
	@Test
	void testExists() {

	}

	@Test
	@DisplayName("free disk space should be positive")
	void testGetFreeDiskSapce() {
		// given
		FileSystem fs = new FileSystem();

		// when
		Long actual = fs.getFreeDiskSapce();

		// then
		//assertTrue(actual > 0l, "free disk space was not  > 0");
		assertThat(actual).isGreaterThan(0);
	}


	@Test
	void testStoreAndLoadSuccessful() {

		FileSystem fs = new FileSystem();

		fs.store("test.txt", "Hello World".getBytes());


		byte[] bytes = fs.load("test.txt");

		assertThat(bytes).containsExactly("Hello World".getBytes());
	}


	@Test
	void load_unknown_file_throws_exception() throws Exception {

		FileSystem  fs = new FileSystem();

		assertThatThrownBy(() -> {
			byte[] load = fs.load( UUID.randomUUID().toString());
		}).isInstanceOf(UncheckedIOException.class);
	}

	@Test
	void load_arbitrary_file() {
		FileSystem fs = new FileSystem();

		assertThatThrownBy( () -> {
			fs.load( "../../.../../../.../../../usr/bin/bash");
		} ).isInstanceOf(SecurityException.class).hasMessageContaining("Access to", "denied");
	}

}
