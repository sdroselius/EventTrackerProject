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

class DirtyDrinkAddInTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private DirtyDrinkAddIn dirtyDrinkAddIn;

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
		DirtyDrinkAddInId id = new DirtyDrinkAddInId(1, 9);
		dirtyDrinkAddIn = em.find(DirtyDrinkAddIn.class, id);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dirtyDrinkAddIn = null;
	}

	@Test
	void test_DirtyDrinkAddIn_entity_mapping() {
		assertNotNull(dirtyDrinkAddIn);
		assertEquals(1.0, dirtyDrinkAddIn.getAmount());
	}

}
