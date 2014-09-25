package net.viralpatel.hibernate.otm.xml.list;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		creerDepartment2(session, 2);
		session.close();
	}
	
	
	private static void creerDepartment1(Session session, int numDept){
		
		session.beginTransaction();
		
		Department department = new Department();
		department.setDepartmentName("Sales"+numDept);
		session.save(department);

		Employe emp1 = new Employe("Nina", "Mayers", "111");
		Employe emp2 = new Employe("Tony", "Almeida", "222");
		
		department.setEmployes(new ArrayList<Employe>());
		department.getEmployes().add(emp1);
		department.getEmployes().add(emp2);
		
		session.save(department);

		session.getTransaction().commit();
	}
	
	
private static void creerDepartment2(Session session, int numDept){
		
		session.beginTransaction();
		
		Department department = new Department();
		department.setDepartmentName("Sales"+numDept);
		

		Employe emp1 = new Employe("Nina", "Mayers", "111");
		Employe emp2 = new Employe("Tony", "Almeida", "222");
		
		department.setEmployes(new ArrayList<Employe>());
		department.getEmployes().add(emp1);
		department.getEmployes().add(emp2);
		
		session.save(department);

		session.getTransaction().commit();
	}
}
