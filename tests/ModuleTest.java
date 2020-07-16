package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import coursework8002Part1Package.Module;

public class ModuleTest {

	@Before
	public void setUp() throws Exception {

		Module.loadModules();
		Module.getAllModules();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readFileRelativePath() {
		File file = new File("src\\coursework8002Part1Package\\ModuleInfo.txt");
		assertTrue(file.exists());
	}

	@Test
	public void valueOfTest() {

		String moduleString = "CSC8002, Thesis, 60";

		Module module = Module.valueOf(moduleString);

		Module module2 = new Module("Thesis", "CSC8002", 60);

		assertEquals(module.toString(), module2.toString());

	}
}
