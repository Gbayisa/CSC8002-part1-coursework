package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Name;
import coursework8002Part1Package.SmartCardNumber;
import coursework8002Part1Package.StudentID;

public class SmartCardNumberTest {
	SmartCardNumber cardNumber1;
	SmartCardNumber cardNumber2;
	StudentID studentID;
	Date yearOfIssue;
	Name name;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetInstance() {
		assertNotNull(SmartCardNumber.getInstance(new Name("George", "Clooney")));
	}

	@Test
	public void testSmartCardNumber2() {
		SmartCardNumber s1 = SmartCardNumber.getInstance(new Name("George", "Clooney"));
		SmartCardNumber s2 = SmartCardNumber.getInstance(new Name("Gerald", "Clooney"));
		SmartCardNumber s3 = SmartCardNumber.getInstance(new Name("Tom", "Clooney"));

		assertEquals(s1.toString(), "GC-2020-00");
		assertEquals(s2.toString(), "GC-2020-01");
		assertEquals(s3.toString(), "TC-2020-00");

	}

}
