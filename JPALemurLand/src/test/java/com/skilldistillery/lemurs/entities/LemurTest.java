package com.skilldistillery.lemurs.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LemurTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Lemur lemur;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("LemurPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		lemur = em.find(Lemur.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		lemur = null;
	}

	@Test
	void test_Lemur_entity_mapping() {
		assertNotNull(lemur);
		assertEquals("Lena", lemur.getName());
	}

}
