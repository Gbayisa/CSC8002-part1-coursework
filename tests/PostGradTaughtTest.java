package tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Name;
import coursework8002Part1Package.PostGradTaught;
import coursework8002Part1Package.StudentType;

public class PostGradTaughtTest {
	PostGradTaught student1;
	PostGradTaught student2;

	@Before
	public void setUp() throws Exception {

		Name name1 = new Name("John", "Smith");
		Name name2 = new Name("Emily", "Smith");

		// Put different age
		Date date1 = new Date();
		date1.setTime(634172400); // 1990 Feb 5th
		Date date2 = new Date();

		student1 = new PostGradTaught(name1, date1, StudentType.UG, new HashSet<String>());
		student2 = new PostGradTaught(name2, date2, StudentType.UG, new HashSet<String>());

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistrationStatus() {

		student2.registerModule("CSC8002");
		student2.registerModule("CSC8005");
		assertEquals(student2.getRegistrationStatus(), false);
		student2.registerModule("CSC8001");
		student2.registerModule("CSC8099");
		assertEquals(student2.getRegistrationStatus(), true);

	}

	@Test
	public void testEligibleForCard() {

		student1.eligibleForCard();
		student2.eligibleForCard();

		assertEquals(student1.eligibleForCard(), true);
		assertEquals(student2.eligibleForCard(), false);
	}

	@Test
	public void testGetRegisteredModules() {

		student2.registerModule("CSC8002");
		student2.registerModule("CSC8005");

		assertEquals(student2.getRegisteredModules().contains("CSC8002"), true);
		assertEquals(student2.getRegisteredModules().contains("CSC8005"), true);
		assertEquals(student2.getRegisteredModules().contains("CSC80324"), false);
	}

}
