package com.skilldistillery.divelog.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class DiveTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Dive dive;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPADiveLog");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		dive = em.find(Dive.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		dive = null;
	}

	@Test
	void test_Dive_entity_mapping() {
		assertNotNull(dive);
		assertEquals(2001, dive.getDiveDate().getYear());
	}

}
