package com.group2.To_Do_App;

import org.springframework.boot.SpringApplication;

public class TestToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.from(ToDoAppApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
