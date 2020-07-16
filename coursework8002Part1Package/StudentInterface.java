package coursework8002Part1Package;

public interface StudentInterface {

	int getNoOfStudents(String cType);

	String registerStudent(StudentInterface student);

	void ammendStudenData(String studentID, String moduleRemove, String moduleAdd, String lastName);

	String terminateStudent(String StudentID);

}
