package net.viralpatel.hibernate.mtm.anno.norma;
 
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


/**
 * *********************************************************************************************************************************************
 * ****************************************** Many-to-Many Association Annotations Example  ****************************************************
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
//        supprimer(session, "Employe"); 
        
        
//       supprimerObjets(session, "Employe", "employeId", "(26)");
//        supprimer2(session, "Meeting");
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
         
         employe1.addPoste(poste1);
         employe1.addPoste(poste2);
         
//         session.save(employe1);
//         session.save(poste1);
         
         session.save(poste1);
         //
//         poste1.addEmploye(employePoste1);
         
//         EmployePoste employePoste2= new EmployePoste(employe2, poste2, remuneration, dateEmbauche, dateDebut, dateFin);
//         employe2.addEmploye(employePoste2);
//         poste2.addEmploye(employePoste2);
//         EmployePoste employePoste3= new EmployePoste(employe1, poste2, remuneration, dateEmbauche, dateDebut, dateFin);
//         employe1.addEmploye(employePoste3);
//         poste2.addEmploye(employePoste3);

         
         
         session.save(employe1);
         
        
    }
    
    
    
    
    public static void creerPoste(Session session){
        
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
        
        System.out.println(nbLignesSupprimes +" lignes supprim�s dans la table "+nomBean);
   }
    
    
    /**
     * 
     * @param session
     * @param nomBean
     */
    public static void supprimerObjets(Session session, String nomBean, String id, String listeObjets){
   	 	
   	 	String req = listeObjets==null? "From "+nomBean : "From "+nomBean +" where " +id+ " in " + listeObjets;
   	 	Query query1 = session.createQuery(req);
	   	List list = query1.list();
	   	
	   	Iterator it = list.iterator();
	   	while (it.hasNext())
	   	{
	   		session.delete(it.next());
	   	}
	   	
	   	
   	 
//        System.out.println(nbLignesSupprimes +" lignes supprim�s dans la table "+nomBean);
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