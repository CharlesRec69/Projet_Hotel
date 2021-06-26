package Projet_Hibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import com.Model.Salarie;
import com.Model.Produit;
import com.Service.SalarieService;
import com.Service.ChambreService;

public class Principale {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SalarieService cs = new  SalarieService();
		Salarie c1 = new Salarie("Dupond", "Jean");
		
		Produit p1 = new Produit("Sony", "S520", "01/06/2021", 850, "appareil neuf type telephone");
		Produit p2 = new Produit("Nokia", "N70", "14/06/2021", 850, "appareil neuf type telephone");
		
		Set<Produit> ListP = new HashSet<Produit>();
		ListP.add(p1);
		ListP.add(p2);
		
		c1.setProduits(ListP);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		cs.create(c1);
		
		//cs.delete(session, 3);
		//c1.setPrenom("Paul");
		//cs.update(session, 2);
		Salarie c2 = cs.findById(session, 1);
		System.out.println("nom : " + c2.getNom() + ", prenom" + c2.getPrenom() + ", liste produit :" + c2.getProduits().toString());
		
		
		List<Salarie> listeC = cs.findAll(session);
		for(Salarie cli : listeC) {
			System.out.println("nom : " + cli.getNom() + ", prenom" + cli.getPrenom());
		}
		
		ChambreService ps = new ChambreService();
		Produit prod1 = ps.findById(session, 1);
		System.out.println("reference : " + prod1.getReference() + ", prix" + prod1.getPrix());


		List<Produit> listeProd = ps.findAll(session);
		
		for(Produit pr : listeProd) {
			System.out.println("reference : " + pr.getReference() + ", prix" + pr.getPrix());
		}
		
		
		
		session.beginTransaction().commit();
		HibernateUtil.shutdown();
		
		
	}

}
