package duytan.dao;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.ImplicitNameSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.HopDong;
import duytan.entities.KhachHang;
import duytan.entities.SPSuDung;

@Repository
public class SPSuDungDAO {
	@Autowired
	SessionFactory sessionFactory;

	// Lấy tất cả sản phẩm theo cấu trúc table

	public List<SPSuDung> getAll() {

		Session session = sessionFactory.openSession();

		List list = session.createQuery("from SPSuDung").getResultList();

		session.close();

		return list;
	}

	// Lấy tất cả sản phẩm cấu trúc tên sản phẩm, tên khách hàng, kí hiệu, bộ phận
	// quản lý, ngày hoạt động

	public List<Object> showAll(int page, int pagesize) {
		Session session = sessionFactory.openSession();
		String queryString = "select sd.idkh, sd.idsanpham, sp.tensanpham, sp.kihieu , kh.tenkh, bp.tenbophan, sd.ngayhoatdong From SPSuDung sd, SanPham sp, KhachHang kh, BoPhanQL bp where sp.idsanpham = sd.idsanpham and sp.idbophan = bp.idbophan and sd.idkh = kh.idkh";

		Query query = session.createQuery(queryString);

		return query.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();

	}

	// tìm sản phẩm đã đưa vào sử dụng theo ngày hoạt động
	public List<Object> searchSPSuDung(String date) {

		Session session = sessionFactory.openSession();

		Date date1 = new Date();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {
			date1 = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String querysString = "select sd.idkh, sd.idsanpham, sp.tensanpham, sp.kihieu , kh.tenkh, bp.tenbophan, sd.ngayhoatdong From SPSuDung sd, SanPham sp, KhachHang kh, BoPhanQL bp where sp.idsanpham = sd.idsanpham and sp.idbophan = bp.idbophan and sd.idkh = kh.idkh and sd.ngayhoatdong = :date1";
		Query query = session.createQuery(querysString);

		query.setParameter("date1", date);

		return query.getResultList();
	}

	// Thêm mới sản phẩm
	public void insert(SPSuDung spSuDung) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(spSuDung);

		session.getTransaction().commit();

	}
	
	// cập nhật sản phẩm
		public void update(SPSuDung spSuDung) {

			Session session = sessionFactory.getCurrentSession();

			session.beginTransaction();

			session.update(spSuDung);

			session.getTransaction().commit();

		}

	// Xóa khách hàng theo id

	public void delete(int idkh, int idsanpham) {
		 Session session = sessionFactory.getCurrentSession();
		 session.beginTransaction();
		 SPSuDung sp = findById(idkh, idsanpham);
		session.remove(sp);
		session.getTransaction().commit();

	}
	
	
	
	public SPSuDung findById(int idkh, int idsanpham) {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		String hql = "FROM SPSuDung WHERE idkh = :idkh and idsanpham = :idsanpham";
		Query query = session.createQuery(hql);
		query.setParameter("idkh", idkh);
		query.setParameter("idsanpham", idsanpham);
		SPSuDung sp = (SPSuDung) query.getSingleResult();
		return sp;
	}
	
	public int count() {
		Session session = sessionFactory.openSession();
		int result = session.createQuery("from SPSuDung").list().size();
		return result;
	}
	
	
}
