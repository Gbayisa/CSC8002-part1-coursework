package coursework8002Part1Package;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/*
 * 
 */

public class SmartCardNumber {

	private static final Set<String> cardMap = new HashSet<String>();

	private final String strRep;

	public SmartCardNumber(String strRep) {
		this.strRep = strRep;

	}

	public static Set<String> getCardmap() {
		return cardMap;
	}

	public String getStrRep() {
		return strRep;
	}

	public static SmartCardNumber getInstance(Name name) {

		Calendar calendar = Calendar.getInstance();
		int truncYear = calendar.get(Calendar.YEAR);

		String initials = name.getFirstName().toUpperCase().substring(0, 1)
				+ name.getLastName().toUpperCase().substring(0, 1);

		int i = 0;

		while (i < 100 && cardMap.contains(initials + "-" + truncYear + "-" + String.format("%02d", i))) {
			i++;
		}

		if (i < 100) {
			String strRep = initials + "-" + truncYear + "-" + String.format("%02d", i);
			cardMap.add(strRep);
			return new SmartCardNumber(strRep);
		} else {
			System.out.println("Maxed out of unique SmartCard numbers");
			throw new IndexOutOfBoundsException();

		}

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((strRep == null) ? 0 : strRep.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SmartCardNumber other = (SmartCardNumber) obj;
		if (strRep == null) {
			if (other.strRep != null)
				return false;
		} else if (!strRep.equals(other.strRep))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return strRep;
	}

}
