package coursework8002Part1Package;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/*
 * a method to list the modules that the student is registered for.
 *  A module consists of a name (e.g. Programming 2), a module code 
 *  (e.g. CSC1022) and the number of credits associated with the 
 *  module (e.g. 20).
 */

public class Module {

	private String moduleName;
	private String moduleCode;
	private int numberOfCredits;
	private static HashMap<String, Module> moduleHash = new HashMap<String, Module>();

	public Module(String moduleName, String moduleCode, int numberOfCredits) {
		this.moduleName = moduleName;
		this.moduleCode = moduleCode;
		this.numberOfCredits = numberOfCredits;

	}

	public static HashMap<String, Module> getAllModules() {
		if (moduleHash.isEmpty() == true) {
			return loadModules();
		} else {
			return moduleHash;
		}
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public int getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	public static Module valueOf(String file) {

		String[] arrayOfModule = file.split(", ", 3);

		String moduleCode = arrayOfModule[0];
		String moduleName = arrayOfModule[1];
		int moduleCredits = Integer.parseInt(arrayOfModule[2]);

		Module module = new Module(moduleName, moduleCode, moduleCredits);

		return module;
	}

	public static HashMap<String, Module> loadModules() {
		List<String> lines = Collections.emptyList();

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String path = s + "\\src\\coursework8002Part1Package\\ModuleInfo.txt";
		try {

			lines = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Iterator<String> iterator = lines.iterator();

		int n = lines.size();
		int i = 0;
		while (iterator.hasNext() && i < n) {

			Module module = valueOf(lines.get(i));

			moduleHash.put(module.getModuleCode(), module);

			i++;

		}

		return moduleHash;

	}

	@Override
	public String toString() {
		return "Module [moduleName=" + moduleName + ", moduleCode=" + moduleCode + ", numberOfCredits="
				+ numberOfCredits + ", getModuleName()=" + getModuleName() + ", getModuleCode()=" + getModuleCode()
				+ ", getNumberOfCredits()=" + getNumberOfCredits() + "]";
	}

}
