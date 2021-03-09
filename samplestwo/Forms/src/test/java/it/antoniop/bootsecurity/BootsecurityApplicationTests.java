package it.antoniop.bootsecurity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BootsecurityApplicationTests {
	
	private static final String AND_I_LOVE_SPRING_BOOT = ".. and I love Spring Boot!!";
	
	private static final String NAME_NAME_S_ANTONIO = "Name name's Antonio";

	
	@Test
	void contextLoads() {
		assertNotEquals(NAME_NAME_S_ANTONIO, AND_I_LOVE_SPRING_BOOT);
		// 		assertEquals(NAME_NAME_S_ANTONIO, AND_I_LOVE_SPRING_BOOT);
	}
}
