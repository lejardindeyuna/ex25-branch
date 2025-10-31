package com.yac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class Ex25BranchApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex25BranchApplication.class, args);
		
		// 디비연결 안할때
		//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
	}

}
