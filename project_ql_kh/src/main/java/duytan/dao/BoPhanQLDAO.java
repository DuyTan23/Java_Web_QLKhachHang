package duytan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.BoPhanQL;

@Repository
public class BoPhanQLDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	public List<BoPhanQL> getAll(){
		
		Session session = sessionFactory.openSession();
		
		List list = session.createQuery("from BoPhanQL").getResultList();
		
		return list;
		
	}
}
