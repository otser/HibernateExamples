package net.viralpatel.hibernate.mto.xml;
 
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
 * **************************************** XML : Many-to-One Association with Foreign Key Mapping *********************************************
 * *********************************************************************************************************************************************
 */
public class MainManyToOne {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		 creerEmploye(session, 2);
//		 creerAdresseErr(session);
//		 creerAdresseCor(session);
		
//		supprimerEmploye(session,  257);
//		supprimerAdresse(session,  14);
//		afficherEmploye(session, 251);
		
		
		session.getTransaction().commit();
		session.close();

	}
	
	private static void creerEmploye(Session session, int nbAdresses){
		
		Adresse adresse;
		Employe employe = new Employe("Mina CreerEmploye", "Mayers", new Date(121212), "114-857-965");
		
		for (int i = 0; i < nbAdresses; i++) {
			 adresse = new Adresse("10th Street CreerEmploye"+i, "LA"+i, "San Francisco"+i, "U.S.A");	
			 employe.addAdresse(adresse);
		}
		
		session.save(employe);
	}
	
	// Si inverse="false" cascade="all" dans Employe.hbm.xml : Genere une erreur (PropertyValueException: not-null property references a null or transient value)
	// Si inverse="true" cascade="all" dans Employe.hbm.xml : Genere une erreur (PropertyValueException: not-null property references a null or transient value ...Adresse.employe)
	// Si inverse="true" cascade="all" dans Employe.hbm.xml : et cascade="all" dans Adresse.hbm.xml Alors OK
	private static void creerAdresseErr(Session session){
		
		Adresse adresse = new Adresse("10th Street CreerAdresse", "LA", "San Francisco", "U.S.A");
		Employe employe = new Employe("Mina CreerAdresse", "Sidy", new Date(121212), "114-857-965");
		employe.addAdresse(adresse);
		
		session.save(adresse);
	}
	
	// Si inverse="false" cascade="all" dans Employe.hbm.xml : Façon correcte de procéder
		private static void creerAdresseCor(Session session){
			
			Adresse adresse = new Adresse("10th Street CreerAdresse", "LA", "San Francisco", "U.S.A");
			Employe employe = new Employe("Mina CreerAdresse", "Sidy", new Date(121212), "114-857-965");
			employe.addAdresse(adresse);
			
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
					+ employe.getLastname() + " : "+employe.getAdresses().size() +" adresses");
			if (employe.getAdresses()!=null){
				for (Adresse adresse : employe.getAdresses()) {					
					System.out.println(adresse.toString());
				}
			}
		
	}
}
