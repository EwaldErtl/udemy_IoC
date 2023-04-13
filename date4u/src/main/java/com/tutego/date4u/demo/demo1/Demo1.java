package com.tutego.date4u.demo.demo1;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Demo1 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Demo1.class, args);
	}
}


@Component
class DateAtStartTime implements ApplicationRunner { 


	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(LocalDateTime.now());
		System.out.println(args.getNonOptionArgs());
		System.out.println(args.getOptionNames());
		System.out.println(Arrays.toString(args.getSourceArgs()));


		args.getOptionNames().forEach(arg -> System.out.println(args.getOptionValues(arg)));
	}
}