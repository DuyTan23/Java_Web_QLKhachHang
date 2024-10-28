package duytan.dao.account;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import duytan.entities.Role;

@Repository
public class RoleDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public RoleDAO() {

	}
	
	//lấy tất cả Role
	
	public List<Role> getAll() {
		Session session = sessionFactory.openSession();
		List result = session.createQuery("from Role").getResultList();
		return result;
	}

}
