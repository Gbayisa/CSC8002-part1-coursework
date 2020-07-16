package coursework8002Part1Package;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class AbstractStudent {
	private static Map<StudentID, SmartCard> cardStudentHash = new HashMap<>();
	private Name studentName;
	private Date DOB;
	private StudentType cType;
	private static SmartCard smartCard;
	private Supervisor supervisorName;
	public HashSet<String> moduleList = new HashSet<String>();
	public HashSet<String> supervisorList = new HashSet<String>();
	boolean correctlyRegistered;
	final int ageUG = 17;
	final int agePGT = 20;
	final int agePGR = 20;

	public AbstractStudent(Name studentName, Date DOB, StudentType cType) {
		this.studentName = studentName;
		this.DOB = new Date(DOB.getTime());
		this.cType = cType;
		this.correctlyRegistered = getRegistrationStatus();
	}

//////////////////////////////////////////////////////////////////////////////////////
///////////// CARD METHODS
//////////////////////////////////////////////////////////////////////////////////////
	public SmartCard getSmartcard() {
		return smartCard;
	}

	protected void issueCard(StudentID studentID) {
		if (eligibleForCard() == true && cardStudentHash.containsKey(studentID) == false) {

			SmartCard card = new SmartCard(studentName, DOB, cType);
			cardStudentHash.put(studentID, card);

		}
	}

	public boolean eligibleForCard() {
		int givenAge = 0;

		if (cType == StudentType.UG) {
			givenAge = ageUG;
		} else if (cType == StudentType.PGT) {
			givenAge = agePGT;
		} else {
			givenAge = agePGR;
		}

// Get calendar object of today's date
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

// Get calendar object today-minYear years
		calendar.add(Calendar.YEAR, -givenAge);

// Get calendar object of Date of Birth
		Calendar DateOfBirth = Calendar.getInstance();
		DateOfBirth.setTime(DOB);

// Comparison returns negative values if person is younger than givenAge
		int comparison = calendar.compareTo(DateOfBirth);
		if (comparison < 0) {
			return false;
		} else {
			return true;
		}
	}

//////////////////////////////////////////////////////////////////////////////////////
///////////// MODULE METHODS
//////////////////////////////////////////////////////////////////////////////////////

	public void registerModule(String moduleCode) {

	}

	public HashSet<String> getRegisteredModules() {
		return moduleList;
	}

	public static boolean equalsIgnoreCase(String string) {
// TODO Auto-generated method stub
		return false;
	}

	public boolean getRegistrationStatus() {
		return false;
	}

	public StudentType getStudentType() {
		return cType;
	}

	public Name getName() {
		return studentName;
	}

	public Date getDOB() {
		return DOB;
	}

//////////////////////////////////////////////////////////////////////////////////////
///////////// SUPERVISOR METHODS
//////////////////////////////////////////////////////////////////////////////////////

	public void registerSupervisor(Supervisor supervisorName) {

	}

}
