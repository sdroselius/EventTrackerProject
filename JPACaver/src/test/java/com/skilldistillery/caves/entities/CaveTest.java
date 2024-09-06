package com.skilldistillery.caves.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class CaveTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Cave cave;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPACaver");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		cave = em.find(Cave.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		cave = null;
	}

	@Test
	void test_Cave_entity_mapping() {
		assertNotNull(cave);
		assertEquals("Mammoth Cave", cave.getName());
	}

}
