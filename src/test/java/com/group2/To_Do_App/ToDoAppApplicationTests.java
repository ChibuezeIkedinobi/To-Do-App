package com.group2.To_Do_App;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class ToDoAppApplicationTests {

	@Test
	void contextLoads() {
	}

}
