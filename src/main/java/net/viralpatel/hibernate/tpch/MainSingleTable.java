package net.viralpatel.hibernate.tpch;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * In One Table per Class Hierarchy scheme, we store all the class hierarchy in a single SQL table. A discriminator is a key to uniquely identify the base type of the class hierarchy.
 */


/**
 * *********************************************************************************************************************************************
 * **************************************  One Table per Class Hierarchy : SINGLE_TABLE ******************************************
 * *********************************************************************************************************************************************
 */

public class MainSingleTable {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		
		Person person = new Person("Steve", "Balmer");
		session.save(person);

		Employee employee = new Employee("James", "Gosling", "Marketing", new Date());
		session.save(employee);
		
		session.getTransaction().commit();
		session.close();

	}
}
