package coursework8002Part1Package;

import java.util.Date;

public class PostGradResearch extends AbstractStudent {

	/*
	 * 180 credits to graduate, Do not register for modules Supervisor
	 * 
	 */

	private Supervisor supervisorName;

	public PostGradResearch(Name studentName, Date DOB, StudentType StudentType, Supervisor supervisorName) {
		super(studentName, DOB, StudentType);
		this.supervisorName = supervisorName;
	}

	@Override
	public boolean getRegistrationStatus() {
		if (supervisorName == null) {
			return false;
		} else
			return true;

	}

	@Override
	public void registerSupervisor(Supervisor supervisor) {

		if (Supervisor.getAllSupervisors().contains(supervisor) == true) {

			this.supervisorName = supervisor;
		} else {
			throw new IllegalArgumentException("Supervisor " + supervisorName + " doesn't exist");
		}

	}

	public Supervisor getSupervisorName() {
		return supervisorName;
	}

}
