package com.Service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Chambre;


import Projet_Hibernate.HibernateUtil;

public class ChambreService {

	
	public boolean  create (Chambre c1) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(c1);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		return true;
	}
	
	
	public void delete(Session s, int id) {
		
		Chambre c1 = s.get(Chambre.class, id);
		s.delete(c1);
	}
	
	
	
	public void update(Session s, int id) {
		
		Chambre c1 = s.get(Chambre.class, id);
		c1.setNumero_chambre(43);
		s.update(c1);
	}
	
	
	public Chambre findById(Session s, int id) {
		
		Chambre c1 = s.get(Chambre.class, id);
		return c1;
		
	}
	
	
	public List<Chambre> findAll(Session s){
		
		Query q = s.createQuery("from Produit");
		List<Chambre> listeC = q.list();
		return listeC;
	}
	
}
