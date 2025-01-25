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

class DirtyDrinkTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private DirtyDrink drink;

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
		drink = em.find(DirtyDrink.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		drink = null;
	}

	@Test
	void test_DirtyDrink_entity_mapping() {
		assertNotNull(drink);
		assertEquals("Espresso Dew", drink.getName());
	}

}
