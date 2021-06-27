package com.Service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


import com.Model.Hotel;

import Projet_Hibernate.HibernateUtil;


public class HotelService implements Serializable{

	
	public boolean  create (Hotel h1) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(h1);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
		
		return true;
	}
	
	
	public void delete(Session s, int id) {
		
		Hotel h1 = s.get(Hotel.class, id);
		s.delete(h1);
	}
	
	
	
	public void update(Session s, int id) {
		
		Hotel h1 = s.get(Hotel.class, id);
		h1.setNom("Paul");
		s.update(h1);
	}
	
	
	public Hotel findById(Session s, int id) {
		
		Hotel h1 = s.get(Hotel.class, id);
		return h1;
		
	}
	
	
	public List<Hotel> findAll(Session s){
		
		Query q = s.createQuery("from Hotel");
		List<Hotel> listeC = q.list();
		return listeC;
	}
	
	
	
}
