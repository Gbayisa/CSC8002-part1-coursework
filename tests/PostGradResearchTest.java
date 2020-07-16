package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Name;
import coursework8002Part1Package.PostGradResearch;
import coursework8002Part1Package.StudentType;
import coursework8002Part1Package.Supervisor;

public class PostGradResearchTest {
	PostGradResearch student1;
	PostGradResearch student2;
	Supervisor supervisorName;

	@Before
	public void setUp() throws Exception {

		Name name1 = new Name("John", "Smith");
		Name name2 = new Name("Emily", "Smith");

		Date date1 = new Date();
		date1.setTime(634172400); // 1990 Feb 5th
		Date date2 = new Date();

		supervisorName = new Supervisor("Mr.Thomas");

		student1 = new PostGradResearch(name1, date1, StudentType.PGR, null);
		student2 = new PostGradResearch(name2, date2, StudentType.PGR, null);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRegistrationStatus() {

		assertEquals(student1.getRegistrationStatus(), false);

		student1.registerSupervisor(supervisorName);
		student2.registerSupervisor(supervisorName);

		assertEquals(student1.getRegistrationStatus(), true);
		assertEquals(student2.getRegistrationStatus(), true);
		assertNotEquals(student1, student2);

	}

	@Test
	public void testEligibleForCard() {

		student1.eligibleForCard();
		student2.eligibleForCard();

		assertEquals(student1.eligibleForCard(), true);

		assertEquals(student2.eligibleForCard(), false);

	}

}
