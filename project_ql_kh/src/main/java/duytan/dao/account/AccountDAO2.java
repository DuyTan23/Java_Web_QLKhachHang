package duytan.dao.account;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.account.Account;

@Repository
public class AccountDAO2 {

	@Autowired
	SessionFactory sessionFactory;

	public AccountDAO2() {

	}

	// Insert account vào database
	public void insert(Account account) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(account);
		session.getTransaction().commit();
	}

	// Lấy account theo username 

	public List<Account> getById(String name) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Account where username like :name");
		query.setParameter("name",  name );
		return query.getResultList();
	}

}
