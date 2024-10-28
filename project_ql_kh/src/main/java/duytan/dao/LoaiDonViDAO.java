package duytan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.LoaiDonVi;

@Repository
public class LoaiDonViDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public List<LoaiDonVi> getAll(){
		
		Session session = sessionFactory.openSession();
		
		List list = session.createQuery("from LoaiDonVi").getResultList();
		
		return list;
		
	}
}
