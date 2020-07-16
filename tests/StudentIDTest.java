package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StudentIDTest {

	String studentID1;
	String studentID2;
	String studentID3;

	// Constructor
	public StudentIDTest() {

	}

	@Before
	public void setUp() {

		studentID1 = "a0001";
		studentID2 = "b0001";
		studentID3 = "z9999";

	}

	@Test
	public void testStudentID1() {

		assertEquals(studentID1.toString(), "a0001");

	}

	@Test
	public void testStudentID2() {

		assertEquals(studentID2.toString(), "b0001");

	}

	@Test
	public void testStudentID3() {

		assertEquals(studentID3.toString(), "z9999");

	}

}