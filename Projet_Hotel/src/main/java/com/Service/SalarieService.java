package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Model.Salarie;

import Projet_Hibernate.HibernateUtil;


public class SalarieService implements Serializable{

	
	public boolean  create (Salarie s1) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(s1);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		return true;
	}
	
	
	public void delete(Session s, int id) {
		
		Salarie s1 = s.get(Salarie.class, id);
		s.delete(s1);
	}
	
	
	
	public void update(Session s, int id) {
		
		Salarie s1 = s.get(Salarie.class, id);
		s1.setPrenom("Paul");
		s.update(s1);
	}
	
	
	public Salarie findById(Session s, int id) {
		
		Salarie s1 = s.get(Salarie.class, id);
		return s1;
		
	}
	
	
	public List<Salarie> findAll(Session s){
		
		Query q = s.createQuery("from Salarie");
		List<Salarie> listeC = q.list();
		return listeC;
	}
	
	
	
}
