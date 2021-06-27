package Projet_Hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.Model.Directeur;
import com.Model.Salarie;
import com.Service.DirecteurService;
import com.Service.SalarieService;
import com.Service.ChambreService;

public class Principale {

	public static void main(String[] args) {
	

		// appel et creation d un directeur
		DirecteurService ds = new  DirecteurService();
		Directeur d1 = new Directeur("Dupond", "Jean", null);
		
		
		SalarieService ss = new  SalarieService();
		
		// appel et creation de nouveau employes
		Salarie s1 = new Salarie("Berger", "Antoine", 1400, 3);
		Salarie s2 = new Salarie("Dumez", "Justine", 1700, 10);
		Salarie s3 = new Salarie("Durand", "Julien", 2100, 16);
		
		// ajout des employes a la liste d employés
		Set<Salarie> ListS = new HashSet<Salarie>();
		ListS.add(s1);
		ListS.add(s2);
		ListS.add(s3);
		
		d1.setSalaries(ListS);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		ds.create(d1);
		
			
		
		//cs.delete(session, 3);
		//c1.setPrenom("Paul");
		//cs.update(session, 2);
		/*Directeur c2 = ds.findById(session, 1);
		System.out.println("nom : " + c2.getNom() + ", prenom" + c2.getPrenom() + ", liste produit :" + c2.getSalaries().toString());
		
		
		List<Directeur> listeC = ds.findAll(session);
		for(Directeur cli : listeC) {
			System.out.println("nom : " + cli.getNom() + ", prenom" + cli.getPrenom());
		}
		
		ChambreService ps = new ChambreService();
		Salarie prod1 = ps.findById(session, 1);
		System.out.println("reference : " + prod1.getReference() + ", prix" + prod1.getPrix());


		List<Salarie> listeProd = ps.findAll(session);
		
		for(Salarie pr : listeProd) {
			System.out.println("reference : " + pr.getReference() + ", prix" + pr.getPrix());
		}*/
		
		
		
		session.beginTransaction().commit();
		HibernateUtil.shutdown();
		
		
	}

}
