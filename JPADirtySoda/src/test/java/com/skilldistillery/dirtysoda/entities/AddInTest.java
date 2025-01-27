package com.skilldistillery.dirtysoda.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class AddInTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private AddIn addIn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPADirtySoda");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		addIn = em.find(AddIn.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		addIn = null;
	}

	@Test
	void test_AddIn_entity_mapping() {
		assertNotNull(addIn);
		assertEquals("Heavy cream", addIn.getName());
	}

}
