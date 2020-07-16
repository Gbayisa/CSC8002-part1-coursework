package coursework8002Part1Package;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class StudentFactory extends AbstractStudent implements StudentInterface {

	private static HashMap<String, StudentInterface> studentHash = new HashMap<>();

	public StudentFactory(Name studentName, Date DOB, StudentType cType) {
		super(studentName, DOB, cType);

	}

	@Override
	public String registerStudent(StudentInterface student) {
		StudentFactory studentF = (StudentFactory) student;
		Name name = studentF.getName();
		Date DOB = studentF.getDOB();
		StudentType cType = studentF.getStudentType();

		StudentID studentID = StudentID.getInstance();
		issueCard(studentID);
		String sID = studentID.toString();

		if (cType == StudentType.UG) {
			StudentInterface newStudent = (StudentInterface) new UnderGradStudent(name, DOB, cType,
					new HashSet<String>());
			studentHash.put(sID, newStudent);
			return "UG student " + name.getLastName() + " is registered";

		} else if (cType == StudentType.PGT) {
			StudentInterface newStudent = (StudentInterface) new PostGradTaught(name, DOB, cType,
					new HashSet<String>());
			studentHash.put(sID, newStudent);

			return "PGT student " + name.getLastName() + " is registered";

		} else if (cType == StudentType.PGR) {
			StudentInterface newStudent = (StudentInterface) new PostGradResearch(name, DOB, cType, new Supervisor(""));
			studentHash.put(sID, newStudent);

			return "PGR student " + name.getLastName() + " is registered";

		}

		else {
			throw new IllegalArgumentException("Invalid Student");
		}

	}

	@Override
	public int getNoOfStudents(String cType) {
		StudentType studentType;

		if (cType == "UG") {
			studentType = StudentType.UG;
		} else if (cType == "PGT") {
			studentType = StudentType.PGT;
		} else if (cType == "PGR") {
			studentType = StudentType.PGR;
		} else {
			throw new IllegalArgumentException("Invalid Student type");
		}

		int noStudents = 0;
		Iterator<StudentInterface> itr = studentHash.values().iterator();

		while (itr.hasNext()) {

			StudentFactory param = (StudentFactory) itr.next();

			if (param.getStudentType().equals(studentType)) {
				noStudents++;
			}
		}
		return noStudents;
	}

	@Override
	public void ammendStudenData(String studentID, String moduleRemove, String moduleAdd, String lastName) {

		if (studentHash.containsKey(studentID)) {
			StudentFactory studentFactory = (StudentFactory) studentHash.get(studentID);

			// ModuleRemove

			if (moduleRemove != null && studentFactory.getRegisteredModules().contains(moduleRemove)) {
				studentFactory.getRegisteredModules().remove(moduleRemove);
				StudentInterface newStudent = studentFactory;
				studentHash.replace(studentID, newStudent);
			}
			// Module add
			if (moduleAdd != null && studentFactory.getRegisteredModules().contains(moduleAdd) == false
					&& Module.getAllModules().containsKey(moduleAdd)) {
				studentFactory.getRegisteredModules().add(moduleAdd);
				StudentInterface newStudent = studentFactory;
				studentHash.replace(studentID, newStudent);

			}

			// LastName change

			if (lastName != null) {
				studentFactory.getName().setLastName(lastName);
				StudentInterface newStudent = studentFactory;
				studentHash.replace(studentID, newStudent);
			}

		} else {
			throw new IllegalArgumentException("Invalid Student ID");
		}

	}

	@Override
	public String terminateStudent(String studentID) {

		if (studentHash.containsKey(studentID)) {
			studentHash.remove(studentID);
			return "Student with ID " + studentID + " is terminated";

		} else {
			throw new IllegalArgumentException("Invalid Student ID");
		}

	}

}