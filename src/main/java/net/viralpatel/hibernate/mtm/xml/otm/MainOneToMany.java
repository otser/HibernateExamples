package net.viralpatel.hibernate.mtm.xml.otm;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 

/**
 * *********************************************************************************************************************************************
 * ****************************************** One-to-Many Using Join Table XML Mapping Example *************************************************
 * *********************************************************************************************************************************************
 */
public class MainOneToMany {
 
    public static void main(String[] args) {
 
    	
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
//        ***************************************** Creation **********************************************
//        creerEmploye(session);
        creerPoste(session);
        
        
//      ***************************************** Suppression **********************************************        
//        supprimer(session, "Employe"); 
        
        
//       supprimerObjets(session, "Employe", "employeId", "(26)");
//        supprimer2(session, "Meeting");
//        selectionner(session,"Employe");
        session.close();
       
    }
    
    public static void creerEmploye(Session session){
    	 session.beginTransaction();
    	 
         Poste poste1 = new Poste(2500f, 'A', "Directeur");
         Poste poste2 = new Poste(2500f, 'A', "Directeur");
         
         Employe Employe1 = new Employe("Sergey", "Brin");
         Employe Employe2 = new Employe("Larry", "Page");

         Employe1.addPoste(poste1);
         Employe1.addPoste(poste2);
         Employe2.addPoste(poste1);
         
         session.save(Employe1);
         session.save(Employe2);
         
         session.getTransaction().commit();
    }
    
    
    
    
    public static void creerPoste(Session session){
   	 session.beginTransaction();
        
   	 Poste poste1 = new Poste(3000f, 'B', "Directeur");
     Poste poste2 = new Poste(3000f, 'B', "Directeur");
     
        Employe employe1 = new Employe("Employe1", "Employe1");
        Employe employe2 = new Employe("Employe2", "Employe2");

        poste1.setEmploye(employe1);
        poste2.setEmploye(employe2);
        
        session.save(poste1);
        session.save(poste2);
        
        session.getTransaction().commit();
   }
    
    
    public static void supprimer(Session session, String nomBean){
   	 	session.beginTransaction();
   	 
   	 	Query query1 = session.createQuery("Delete From "+nomBean);
        
   	 	int nbLignesSupprimes = query1.executeUpdate();
        
        session.getTransaction().commit();
        System.out.println(nbLignesSupprimes +" lignes supprimés dans la table "+nomBean);
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
//        System.out.println(nbLignesSupprimes +" lignes supprimés dans la table "+nomBean);
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