package com.skilldistillery.caves.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class FormationTypeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private FormationType formationType;
	
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
		formationType = em.find(FormationType.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		formationType = null;
	}

	@Test
	void test_FormationType_entity_mapping() {
		assertNotNull(formationType);
		assertEquals("Karst", formationType.getName());
	}

}
