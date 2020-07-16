package coursework8002Part1Package;

import java.util.Calendar;
import java.util.Date;

public class SmartCard {

	private final Name studentName;
	private Date DOB;
	private SmartCardNumber smartCardNumber;
	private Calendar dateOfIssue;
	private Calendar expiryDate;

	public SmartCard(Name studentName, Date DOB, StudentType cType) {
		this.studentName = studentName;
		this.DOB = DOB;
		this.smartCardNumber = getSmartCardNumber();
		this.dateOfIssue = getDateOfIssue();
		this.expiryDate = getExpiryDate(cType);

	}

	public Calendar setExpiryDate(StudentType cType) {

		Calendar temp = dateOfIssue;

		if (cType == StudentType.UG) {
			temp.add(Calendar.YEAR, 4);
			return temp;
		} else if (cType == StudentType.PGT) {
			temp.add(Calendar.YEAR, 2);
			return temp;
		} else {
			temp.add(Calendar.YEAR, 5);
			return temp;
		}

	}

	public Calendar getExpiryDate(StudentType cType) {
		if (expiryDate != null) {
			return expiryDate;
		} else {
			return setExpiryDate(cType);
		}
	}

	public SmartCardNumber getSmartCardNumber() {

		if (smartCardNumber != null) {
			return smartCardNumber;
		} else {
			return SmartCardNumber.getInstance(studentName);
		}

	}

	public Calendar getDateOfIssue() {
		if (dateOfIssue != null) {
			return dateOfIssue;
		} else {
			Calendar date = Calendar.getInstance();
			return date;
		}

	}

	public Date getDOB() {
		return DOB;
	}

	public Name getStudentName() {
		return studentName;
	}

}