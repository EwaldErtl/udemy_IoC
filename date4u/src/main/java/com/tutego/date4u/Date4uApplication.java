package com.tutego.date4u;

import java.util.Arrays;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.unit.DataSize;

@SpringBootApplication
@EnableAsync
public class Date4uApplication {

	private final static Logger logger = LoggerFactory.getLogger(Date4uApplication.class);

	private FileSystem fileSystem;

	public Date4uApplication(FileSystem fileSystem) {
		logger.debug("constructor called");

		this.fileSystem = fileSystem;
	}


	public static void main(String[] args) {
		logger.debug("Starting the application");

		// SpringApplication app = new SpringApplication(Date4uApplication.class);

		// app.run(args);

		ConfigurableApplicationContext context = new SpringApplicationBuilder(Date4uApplication.class).headless(true).bannerMode(Banner.Mode.OFF).run(args);

		Arrays.stream(context.getBeanDefinitionNames()).forEach(logger::info);

		FileSystem fileSystem = context.getBean(FileSystem.class);

		logger.warn("Filesystem free space :  {}", DataSize.ofBytes(fileSystem.getFreeDiskSapce()).toGigabytes());
	}

}
