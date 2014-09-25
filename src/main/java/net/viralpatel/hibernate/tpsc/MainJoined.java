package net.viralpatel.hibernate.tpsc;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * *********************************************************************************************************************************************
 * ************************************** One Table Per Subclass : JOINED ******************************************
 * *********************************************************************************************************************************************
 */
public class MainJoined {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		
//		 CreerPerson(session);
//		 CreerEmployee(session);
//		 CreerOwner(session);
		
		selectionner(session,  Person.class, 1);
		System.out.println("=======================================================================================");
		selectionner(session,  Employee.class, 2);
		System.out.println("=======================================================================================");
		selectionner(session,  Owner.class, 3);
		

		
		session.getTransaction().commit();
		session.close();

	}
	
	
	public static void CreerPerson(Session session){
		Person person = new Person("Steve", "Balmer");
		session.save(person);
	}
	
	public static void CreerEmployee(Session session){
		Employee employee = new Employee("James", "Gosling", "Marketing", new Date());
		session.save(employee);
	}
	
	
	public static void CreerOwner(Session session){
		Owner owner = new Owner("Bill", "Gates", 300L, 20L);
		session.save(owner);
	}
	
	
//	private static void supprimerEmploye(Session session,  int employeId){
//		
//		Employe employe = (Employe) session.load(Employe.class, Long.valueOf(employeId));
//		session.delete(employe);
//	}
	
	
	private static void selectionner(Session session,  Class clazz, int id){		
//		"load" method will always return a “proxy” (Hibernate term) without hitting the database (no select statment againest the database). 
//		In Hibernate, proxy is an object with the given identifier value, its properties are not initialized yet, it just look like a temporary fake object.
//		If no row found , "load" will throws an ObjectNotFoundException.		
//		Object obj = session.load(clazz, Long.valueOf(id));	
		//It always hit the database and return the real object, an object that represent the database row, not proxy. If no row found , it return null.
		Object obj = session.get(clazz, Long.valueOf(id));	
		if(obj!=null){
			System.out.println(obj.toString());
		}else{
			System.out.println("L'objet "+id+" est NULL");
		}
	}
}
