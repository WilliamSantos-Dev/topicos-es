package br.edu.ufage.topicos.preco;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest
class PrecoApplicationTests {
	@SuppressWarnings("resource")
	@Container
	public static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:latest")
			.withDatabaseName("postgres")
			.withUsername("postgres")
			.withPassword("postgres");

	@Test
	void contextLoads() {
	}

}
