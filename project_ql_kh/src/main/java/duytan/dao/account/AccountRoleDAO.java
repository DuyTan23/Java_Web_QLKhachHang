package duytan.dao.account;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.account.AccountRole;

@Repository
public class AccountRoleDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	// Insert account vào database
		public void insert(AccountRole accountRole) {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.save(accountRole);
			session.getTransaction().commit();
		}

}
