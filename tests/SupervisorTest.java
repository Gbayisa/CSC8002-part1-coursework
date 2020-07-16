package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Supervisor;

public class SupervisorTest {

	@Before
	public void setUp() throws Exception {

		Supervisor.loadSupervisors();
		Supervisor.getAllSupervisors();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readFileRelativePath() {
		File file = new File("src\\coursework8002Part1Package\\Supervisors.txt");
		assertTrue(file.exists());
	}

	@Test
	public void valueOfTest() {

		String supervisorString = "Mr.Thomas";

		Supervisor supervisor = Supervisor.valueOf(supervisorString);

		Supervisor supervisor2 = Supervisor.valueOf(supervisorString);

		assertEquals(supervisor.toString(), supervisor.toString());

	}

}
