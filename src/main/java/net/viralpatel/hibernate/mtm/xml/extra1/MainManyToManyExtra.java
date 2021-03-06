package net.viralpatel.hibernate.mtm.xml.extra1;
 
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * *********************************************************************************************************************************************
 * ************************** Many-to-Many Association implemented as 2<one-to-many> + 2<many-to-one> without cascad ***************************
 * *********************************************************************************************************************************************
 */
public class MainManyToManyExtra {
 
    public static void main(String[] args) {
 
    	
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
//        ***************************************** Creation **********************************************
        creerEmploye(session);
//        creerPoste(session);
        
        
//      ***************************************** Suppression **********************************************        
//        supprimerEmploye(session, 61); 
        
        
//       supprimerObjets(session, "Employe", "employeId", "(61)");
//        selectionner(session,"Employe");
        session.getTransaction().commit();
        session.close();
       
    }
    
    
    
   
   
   
   
    public static void creerEmploye(Session session){
    	
    	 
    	 	Float remuneration = 3600f;
    	 	Calendar cal = Calendar.getInstance();
    	 	cal.add(Calendar.YEAR, -5);
    		Date dateEmbauche = cal.getTime();
    		cal.add(Calendar.YEAR, 1);
    		Date dateDebut =cal.getTime();
    		cal.add(Calendar.YEAR, 8);
    		Date dateFin = cal.getTime();

    	 
         Poste poste1 = new Poste(2500f, 'A', "Directeur");
         Poste poste2 = new Poste(2500f, 'A', "Directeur");
         
         Employe employe1 = new Employe("Sergey", "Brin");
         Employe employe2 = new Employe("Larry", "Page");
         session.save(employe1);
         session.save(poste1);
         
         
         EmployePoste employePoste1= new EmployePoste(employe1, poste1, remuneration, dateEmbauche, dateDebut, dateFin);
         employePoste1.setEmploye(employe1);
         employePoste1.setPoste(poste1);
         //

//       session.save(employe1);
//       session.save(poste1);
         session.save(employePoste1);
         
//         session.save(employePoste1);
//         session.save(employePoste2);
//         session.save(employePoste3);
         
        
    }
    
    
    
    
    public static void creerPoste(Session session){
   	 session.beginTransaction();
        
   	 Poste poste1 = new Poste(3000f, 'B', "Directeur");
     Poste poste2 = new Poste(3000f, 'B', "Directeur");
     
        Employe employe1 = new Employe("Employe1", "Employe1");
        Employe employe2 = new Employe("Employe2", "Employe2");

//        poste1.addEmploye(employe1);
//        poste2.addEmploye(employe2);
        
        session.save(poste1);
        session.save(poste2);
        
        session.getTransaction().commit();
   }
    
    
    public static void supprimer(Session session, String nomBean){
   	 	session.beginTransaction();
   	 
   	 	Query query1 = session.createQuery("Delete From "+nomBean);
        
   	 	int nbLignesSupprimes = query1.executeUpdate();
        
        session.getTransaction().commit();
        System.out.println(nbLignesSupprimes +" lignes supprim�s dans la table "+nomBean);
   }
    
    
    /**
     * 
     * @param session
     * @param nomBean
     */
    public static void supprimerObjets(Session session, String nomBean, String id, String listeObjets){
   	 	session.beginTransaction();
   	 	
   	 	String req = listeObjets==null? "From "+nomBean : "From "+nomBean +" where " +id+ " in " + listeObjets;
   	 	Query query1 = session.createQuery(req);
	   	List list = query1.list();
	   	
	   	Iterator it = list.iterator();
	   	while (it.hasNext())
	   	{
	   		session.delete(it.next());
	   	}
	   	
	   	
   	 
        session.getTransaction().commit();
//        System.out.println(nbLignesSupprimes +" lignes supprim�s dans la table "+nomBean);
   }
    
    
    private static void supprimerEmploye(Session session,  int employeId){
		
		Employe employe = (Employe) session.load(Employe.class, Long.valueOf(employeId));
		session.delete(employe);
	}
    
    /**
     * 
     * @param session
     * @param nomBean
     */
    public static void selectionner(Session session, String nomBean){
    	Query query1 = session.createQuery("From "+nomBean);
    	List list = query1.list();
    	afficherList(list);
    }
    
    
    /**
     * 
     * @param list
     */
    public static void afficherList(List list){
    	for (Object o : list){
    		System.out.println(o.toString());
    	}
    }
    
}