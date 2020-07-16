package coursework8002Part1Package;

public final class StudentID {

	private final static int maxID = 9999;

	private static String sID;

	private static char chMin = 'a';

	private static int minID = 0;

	/**
	 * @param letter
	 * @param number
	 */

	public StudentID(char chMin, int minID) {
		StudentID.chMin = chMin;
		StudentID.minID = minID;
		StudentID.sID = String.format("%c%04d", chMin, minID);
		// string representation letter + number via concatenation
	}

	public final String getsID() {
		return sID;
	}

	public static StudentID getInstance() throws IllegalArgumentException {

		if (minID == maxID) {
			chMin = (char) (chMin + 1);
			minID = 0;

		}

		else {
			minID++;
		}

		return new StudentID(chMin, minID);

	}

	@Override
	public String toString() {
		return getsID();
	}

}
