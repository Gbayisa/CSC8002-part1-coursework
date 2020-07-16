package tests;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Module;
import coursework8002Part1Package.Name;
import coursework8002Part1Package.StudentType;
import coursework8002Part1Package.UnderGradStudent;

public class UnderGradStudentTest {
	UnderGradStudent student1;
	UnderGradStudent student2;
	HashMap<String, Module> moduleHash;

	@Before
	public void setUp() throws Exception {

		Name name1 = new Name("John", "Smith");
		Name name2 = new Name("Emily", "Smith");

		// Put different age
		Date date1 = new Date();
		date1.setTime(634172400); // 1990 Feb 5th
		Date date2 = new Date();

		student1 = new UnderGradStudent(name1, date1, StudentType.UG, new HashSet<String>());
		student2 = new UnderGradStudent(name2, date2, StudentType.UG, new HashSet<String>());

		HashMap<String, Module> moduleHash = new HashMap<String, Module>();

		Module module1 = new Module("Thesis", "CSC8099", 60);
		Module module2 = new Module("Java Programming", "CSC8001", 20);
		Module module3 = new Module("Software Engineering and Group Project", "CSC8005", 80);

		moduleHash.put("CSC8099", module1);
		moduleHash.put("CSC8001", module2);
		moduleHash.put("CSC8005", module3);

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
