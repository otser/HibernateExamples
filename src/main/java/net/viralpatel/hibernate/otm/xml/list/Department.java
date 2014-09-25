package net.viralpatel.hibernate.otm.xml.list;

import java.util.ArrayList;
import java.util.List;


public class Department {

	private Long departmentId;
	
	private String departmentName;
	
	private List<Employe> employes = new ArrayList<Employe>();

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

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
}
