package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Directeur;

import Projet_Hibernate.HibernateUtil;


public class DirecteurService implements Serializable{

	
	public boolean  create (Directeur d1) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(d1);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		return true;
	}
	
	
	public void delete(Session s, int id) {
		
		Directeur d1 = s.get(Directeur.class, id);
		s.delete(d1);
	}
	
	
	
	public void update(Session s, int id) {
		
		Directeur d1 = s.get(Directeur.class, id);
		d1.setPrenom("Paul");
		s.update(d1);
	}
	
	
	public Directeur findById(Session s, int id) {
		
		Directeur d1 = s.get(Directeur.class, id);
		return d1;
		
	}
	
	
	public List<Directeur> findAll(Session s){
		
		Query q = s.createQuery("from Directeur");
		List<Directeur> listeC = q.list();
		return listeC;
	}
	
	
	
}
