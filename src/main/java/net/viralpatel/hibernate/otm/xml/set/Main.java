package net.viralpatel.hibernate.otm.xml.set;
 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.viralpatel.hibernate.otm.xml.set.Department;
import net.viralpatel.hibernate.otm.xml.set.Employe;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
 
public class Main {
 
    public static void main(String[] args) {
 
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        
        
//        creerEmployes1(session, 2);
//        creerEmployes2(session, 2);
        
//        creerDepartement(session);
        
        supprimerEmploye(session, 124, 236);
        
        session.getTransaction().commit();
        session.close();
    }
    
    
//   Avec inverse="true" Dans le mapping de Department
	private static void creerEmployes1(Session session, int nbEmploye){
		
		
		Department department = new Department();
		department.setDepartmentName("SalesSet");
		session.save(department);

		Employe emp1;
		for (int i = 0; i < nbEmploye; i++) {
			 emp1 = new Employe("Employe"+i, "Mayers"+i, "111"+i);
			 emp1.setDepartment(department);
			 session.save(emp1);
		}
		
	}
	
	//  Avec inverse="true" Dans le mapping de Department
	private static void creerEmployes2(Session session, int nbEmploye){
			
			
			Department department = new Department();
			department.setDepartmentName("SalesSet");
			
	
			Employe emp1;
			for (int i = 0; i < nbEmploye; i++) {
				 emp1 = new Employe("Employe"+i, "Mayers"+i, "111"+i);
				 emp1.setDepartment(department);
				 session.save(emp1);
			}
			
		}


	//Avec inverse="false" cascade="all" Dans le mapping de Department
	private static void creerDepartement(Session session){
		Department department = new Department();
		department.setDepartmentName("Sales");
		
		
		Employe emp1 = new Employe("Mina", "Mayers", "26276643");
		Employe emp2 = new Employe("Mina", "Maham", "26276643");
		emp1.setDepartment(department);
		emp2.setDepartment(department);
		department.getEmployes().add(emp1);
		department.getEmployes().add(emp2);
		
		session.save(department);
	}



	/**
	 * 
	 * @param session
	 * @param departmentId
	 * @param employeId
	 */
	private static void supprimerEmploye(Session session, int departmentId, int employeId){
		
		Query query1 = session.createQuery("Select d From net.viralpatel.hibernate.otm.xml.set.Department d where d.departmentId=?");
		query1.setParameter(0, Long.valueOf(departmentId));
    	Department department = (Department)query1.uniqueResult();
    	Set<Employe> employes = department.getEmployes();
//    	Employe[] arrayView = (Employe[])employes.toArray();
    	 // Converting our set to Array
    	Employe[] arrayView = employes.toArray(new Employe[employes.size()]);
    	
    	for (int i=0; i < arrayView.length; i++){
    		if(arrayView[i].getEmployeId().equals(Long.valueOf(employeId))){
    			department.getEmployes().remove(arrayView[0]);
    	    	session.save(department);   
    	    	break;
    		}
    		
    	}
    	 		
	}

	

}