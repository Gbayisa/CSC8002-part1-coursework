package tests;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Name;
import coursework8002Part1Package.SmartCard;
import coursework8002Part1Package.StudentType;

public class SmartCardTest {

	SmartCard smartCard1;
	Calendar date;

	@Before
	public void setUp() throws Exception {

		Name name1 = new Name("John", "Smith");

		Date dob = new Date();

		smartCard1 = new SmartCard(name1, dob, StudentType.UG);
	}

	@Test
	public void testExpiryDate() {

		Calendar expiryUG = Calendar.getInstance();
		Calendar expiryPGT = Calendar.getInstance();
		Calendar expiryPGR = Calendar.getInstance();

		expiryUG.add(Calendar.YEAR, 4);
		expiryPGT.add(Calendar.YEAR, 2);
		expiryPGR.add(Calendar.YEAR, 5);

		smartCard1.setExpiryDate(StudentType.UG);
		assertEquals(smartCard1.getExpiryDate(StudentType.UG), expiryUG);

	}

}
