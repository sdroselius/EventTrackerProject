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

class DiveSiteTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private DiveSite site;
	
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
		site = em.find(DiveSite.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		site = null;
	}

	@Test
	void test_DiveSite_entity_mapping() {
		assertNotNull(site);
		assertEquals("Great Blue Hole", site.getName());
	}

	@Test
	void test_DiveSite_Destination_MTO_mapping() {
		assertNotNull(site);
		assertNotNull(site.getDestination());
		assertEquals("Lighthouse Reef", site.getDestination().getName());
	}
	
}
