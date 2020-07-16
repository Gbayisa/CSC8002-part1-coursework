package coursework8002Part1Package;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

public class UnderGradStudent extends AbstractStudent {

	final int credits = 120;

	public UnderGradStudent(Name studentName, Date DOB, StudentType cType, HashSet<String> moduleList) {
		super(studentName, DOB, cType);
		this.moduleList = moduleList;
	}

	@Override
	public boolean getRegistrationStatus() {
		if (countTotalCredits(moduleList) >= credits) {
			return true;
		} else
			return false;
	}

	private int countTotalCredits(HashSet<String> registeredModules) {
		int totalCredits = 0;

		if (registeredModules == null) {
			return 0;
		} else {
			Iterator<String> itr = registeredModules.iterator();

			while (itr.hasNext()) {
				Module module = Module.getAllModules().get(itr.next());
				totalCredits = totalCredits + module.getNumberOfCredits();

			}

			return totalCredits;
		}
	}

	@Override
	public void registerModule(String moduleCode) {

		if (Module.getAllModules().containsKey(moduleCode) == true) {

			this.moduleList.add(moduleCode);
		} else {
			throw new IllegalArgumentException("Module " + moduleCode + " doesn't exist");
		}

	}

	@Override
	public HashSet<String> getRegisteredModules() {
		return moduleList;
	}

}
