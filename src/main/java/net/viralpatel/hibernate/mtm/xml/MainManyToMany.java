package net.viralpatel.hibernate.mtm.xml;
 
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class MainManyToMany {
 
    public static void main(String[] args) {
 
    	
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
//        ***************************************** Creation **********************************************
        saveEmploye(session);
//        saveMeeting(session);
        
        
//      ***************************************** Suppression **********************************************        
//        supprimer(session, "Employe"); 
        
        
//       supprimerObjets(session, "Employe", "employeId", "(26)");
//        supprimer2(session, "Meeting");
        selectionner(session,"Employe");
        session.close();
       
    }
    
    public static void saveEmploye(Session session){
    	 session.beginTransaction();
    	 
         Meeting meeting1 = new Meeting("Quaterly Sales meeting", Categorie.A);
         Meeting meeting2 = new Meeting("Weekly Status meeting", Categorie.B);
         
         Employe Employe1 = new Employe("Sergey", "Brin");
         Employe Employe2 = new Employe("Larry", "Page");

         Employe1.getMeetings().add(meeting1);
         Employe1.getMeetings().add(meeting2);
         Employe2.getMeetings().add(meeting1);
         
         session.save(Employe1);
         session.save(Employe2);
         
         session.getTransaction().commit();
    }
    
    
    
    
    public static void saveMeeting(Session session){
   	 session.beginTransaction();
        
        Meeting meeting1 = new Meeting("Meeting1", Categorie.C);
        Meeting meeting2 = new Meeting("Meeting2", Categorie.D);
        
        Employe employe1 = new Employe("Employe1", "Employe1");
        Employe employe2 = new Employe("Employe2", "Employe2");

        meeting1.getEmployes().add(employe1);
        meeting1.getEmployes().add(employe2);
        meeting2.getEmployes().add(employe1);
        
//        employe1.getMeetings().add(meeting1);
//        employe1.getMeetings().add(meeting2);
//        employe2.getMeetings().add(meeting1);
        
        session.save(meeting1);
        session.save(meeting2);
        
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