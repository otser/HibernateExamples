package net.viralpatel.hibernate.oto.xml;

import java.sql.Date;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Main {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

//		 creerEmploye(session);
//		 creerDetail(session);
		
//		supprimerEmploye(session,  245);
		supprimerDetail(session,  246);
//		afficherEmployes(session, 239);
		
		
		session.getTransaction().commit();
		session.close();

	}
	
	private static void creerEmploye(Session session){
		
		EmployeDetail employeDetail = new EmployeDetail("10th Street", "LA", "San Francisco", "U.S.");
		
		Employe employe = new Employe("Mina", "Mayers", new Date(121212), "114-857-965");
		employe.setEmployeDetail(employeDetail);
		employeDetail.setEmploye(employe);
		
		
		session.save(employe);
	}
	
	
	private static void creerDetail(Session session){
		
		EmployeDetail employeDetail = new EmployeDetail("10th Street", "LA", "San Francisco", "U.S.");
		
		Employe employe = new Employe("Mina", "Sidy", new Date(121212), "114-857-965");
		employe.setEmployeDetail(employeDetail);
		employeDetail.setEmploye(employe);
		
		
		session.save(employeDetail);
	}
	
	
	/**
	 * 
	 * @param session
	 * @param employeId
	 */
	private static void supprimerEmploye(Session session,  int employeId){
			
			Query query1 = session.createQuery("Select d From net.viralpatel.hibernate.oto.xml.Employe d where d.employeId=?");
			query1.setParameter(0, Long.valueOf(employeId));
			Employe employe = (Employe)query1.uniqueResult();
			session.delete(employe);;
		}
	
	/**
	 * 
	 * @param session
	 * @param employeId
	 */
	private static void supprimerDetail(Session session,  int employeId){
		
		Query query1 = session.createQuery("Select d From net.viralpatel.hibernate.oto.xml.EmployeDetail d where d.employeId=?");
		query1.setParameter(0, Long.valueOf(employeId));
		EmployeDetail employeDetail = (EmployeDetail)query1.uniqueResult();
//		employeDetail.setEmploye(null);
		employeDetail.getEmploye().setEmployeDetail(null);
		session.delete(employeDetail);
	}


	/**
	 * 
	 * @param session
	 * @param minId
	 */
	private static void afficherEmployes(Session session, int minId){
		
		List<Employe> employes = session.createQuery("from Employe e where e.employeId>"+minId).list();
		for (Employe employe1 : employes) {
			System.out.println(employe1.getFirstname() + " , "
					+ employe1.getLastname() + ", "
					+ employe1.getEmployeDetail().getState());
		}

	}
}
