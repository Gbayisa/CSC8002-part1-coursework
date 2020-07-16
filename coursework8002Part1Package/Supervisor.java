package coursework8002Part1Package;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Supervisor {

	private String supervisorName;
	private static HashSet<Supervisor> supervisorSet = new HashSet<Supervisor>();

	public Supervisor(String supervisorName) {
		this.supervisorName = supervisorName;
	}

	public static HashSet<Supervisor> getAllSupervisors() {
		if (supervisorSet.isEmpty() == true) {
			return loadSupervisors();
		} else {
			return supervisorSet;
		}
	}

	public String getSupervisorName() {
		return supervisorName;
	}

	public static Supervisor valueOf(String string) {

		Supervisor supervisor = new Supervisor(string);

		return supervisor;
	}

	public static HashSet<Supervisor> loadSupervisors() {
		List<String> lines = Collections.emptyList();

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String path = s + "\\src\\coursework8002Part1Package\\Supervisors.txt";
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

			Supervisor supervisor = valueOf(lines.get(i));

			supervisorSet.add(supervisor);

			i++;

		}

		return supervisorSet;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((supervisorName == null) ? 0 : supervisorName.hashCode());
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
		Supervisor other = (Supervisor) obj;
		if (supervisorName == null) {
			if (other.supervisorName != null)
				return false;
		} else if (!supervisorName.equals(other.supervisorName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Supervisor [supervisorName=" + supervisorName + ", getSupervisorName()=" + getSupervisorName()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
}
