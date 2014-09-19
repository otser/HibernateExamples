package net.viralpatel.hibernate.mto.xml.oto;
 
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;





import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




/**
 * *********************************************************************************************************************************************
 * ************************************** One-to-One Association Annotations with Foreign Key Mapping ******************************************
 * *********************************************************************************************************************************************
 */
public class MainOneToOne {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

//		 creerEmploye(session);
//		 creerAdresseErr(session);
//		 creerAdresseCor(session);
		
		supprimerEmploye(session,  278);
//		supprimerAdresse(session,  18);
//		afficherEmploye(session, 251);
		
		
		session.getTransaction().commit();
		session.close();

	}
	
	private static void creerEmploye(Session session){
		
		Employe employe = new Employe("Mina CreerEmploye", "Mayers", new Date(121212), "114-857-965");
		Adresse adresse = new Adresse("10th Street CreerEmploye", "LA", "San Francisco", "U.S.A");	
		adresse.setEmploye(employe);
		employe.setAdresse(adresse);
		
		 session.save(employe);
	}
	
	private static void creerAdresseErr(Session session){
		
		Adresse adresse = new Adresse("10th Street CreerAdresse", "LA", "San Francisco", "U.S.A");
		Employe employe = new Employe("Mina CreerAdresse", "Sidy", new Date(121212), "114-857-965");
		adresse.setEmploye(employe);
		employe.setAdresse(adresse);
		
		session.save(adresse);
	}
	
		private static void creerAdresseCor(Session session){
			
//			Adresse adresse = new Adresse("10th Street CreerAdresse", "LA", "San Francisco", "U.S.A");
			Employe employe = new Employe("Mina CreerAdresse", "Sidy", new Date(121212), "114-857-965");
//			employe.setAdresse(adresse);
			
			session.save(employe);
		}
	
	
	/**
	 * 
	 * @param session
	 * @param employeId
	 */
	private static void supprimerEmploye(Session session,  int employeId){
			
			Employe employe = (Employe) session.load(Employe.class, Long.valueOf(employeId));
			session.delete(employe);
		}
	
	/**
	 * 
	 * @param session
	 * @param employeId
	 */
	private static void supprimerAdresse(Session session,  int adresseId){
		
		Adresse adresse = (Adresse) session.load(Adresse.class, Long.valueOf(adresseId));
		session.delete(adresse);
	}


	/**
	 * 
	 * @param session
	 * @param minId
	 */
	private static void afficherEmploye(Session session, int employeId){
		
		Employe employe = (Employe)session.createQuery("from net.viralpatel.hibernate.mto.xml.Employe e where e.employeId="+employeId).uniqueResult();
			System.out.println("------------------------------------------------------------");
			System.out.println(employe.getFirstname() + " , "
					+ employe.getLastname() + " : ");
			if (employe.getAdresse()!=null){
					System.out.println(employe.getAdresse().toString());
			}
		
	}
}
