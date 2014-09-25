package net.viralpatel.hibernate.otm.xml.set;

import java.util.HashSet;
import java.util.Set;

import net.viralpatel.hibernate.otm.xml.set.Employe;

public class Department {

	private Long departmentId;
	
	private String departmentName;
	
	private Set<Employe> employes = new HashSet<Employe>();

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}

}
