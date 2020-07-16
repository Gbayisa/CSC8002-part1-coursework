package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Name;

public class NameTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testFirstName() {
		Name name = new Name("Thomas", "Jefferson");
		assertEquals("Thomas", name.getFirstName());

	}

	@Test
	public void test() {
		Name name = new Name("Thomas", "Jefferson");
		assertEquals("Jefferson", name.getLastName());

	}

}
