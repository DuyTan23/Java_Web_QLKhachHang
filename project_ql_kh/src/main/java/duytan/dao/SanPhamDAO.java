package duytan.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.HopDong;
import duytan.entities.SanPham;

@Repository
public class SanPhamDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<Object> getAll(int page, int pagesize) {
		Session session = sessionFactory.openSession();

		String queryString = "select sp.idsanpham, sp.tensanpham, sp.kihieu, sp.tinhtrang, bp.tenbophan from SanPham sp, BoPhanQL bp where sp.idbophan = bp.idbophan";

		Query query = session.createQuery(queryString);

		return query.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();
	}

	public List<SanPham> getAll2() {
		Session session = sessionFactory.openSession();

		List list = session.createQuery("from SanPham").getResultList();

		return list;
	}

	public int count() {
		Session session = sessionFactory.openSession();
		int result = session.createQuery("from SanPham").list().size();
		return result;
	}

	// tìm sản phẩm theo tình trạng hoàn thành

	public List<Object> searchSP_tinhTrang(String tinhtrang) {

		Session session = sessionFactory.openSession();

		String queryString = "select sp.idsanpham, sp.tensanpham, sp.kihieu, sp.tinhtrang, bp.tenbophan from SanPham sp, BoPhanQL bp where sp.idbophan = bp.idbophan and sp.tinhtrang like :tinhtrang";

		Query query = session.createQuery(queryString);

		query.setParameter("tinhtrang", tinhtrang);

		return query.getResultList();
	}
	// tìm sản phẩm theo bộ phận quản lý

	public List<Object> searchSP_bophan(int idbophan) {

		Session session = sessionFactory.openSession();

		String queryString = "select sp.idsanpham, sp.tensanpham, sp.kihieu, sp.tinhtrang, bp.tenbophan from SanPham sp, BoPhanQL bp where sp.idbophan = bp.idbophan and sp.idbophan = :idbophan";

		Query query = session.createQuery(queryString);

		query.setParameter("idbophan", idbophan);

		return query.getResultList();
	}

	// tìm sản phẩm theo tên và kí hiệu

	public List<Object> searchSP_tenkh(String tensanpham, String kihieu) {

		Session session = sessionFactory.openSession();

		String queryString = "select sp.idsanpham, sp.tensanpham, sp.kihieu, sp.tinhtrang, bp.tenbophan from SanPham sp, BoPhanQL bp where sp.idbophan = bp.idbophan and sp.tensanpham like :tensanpham and sp.kihieu like :kihieu";

		Query query = session.createQuery(queryString);

		query.setParameter("tensanpham", "%" + tensanpham + "%");
		query.setParameter("kihieu", "%" + kihieu + "%");

		return query.getResultList();
	}

	// lấy sản phẩm theo id với cấu trúc bảng khách hàng

	public SanPham getById(int id) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		SanPham sanPham = session.get(SanPham.class, id);

		session.getTransaction().commit();

		return sanPham;
	}

	// Cập nhật sản phẩm
	public void update(SanPham sanPham) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.update(sanPham);

		session.getTransaction().commit();

	}

	// Xóa sản phẩm
	public void delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		var kh = session.get(SanPham.class, id);

		session.remove(kh);

		session.getTransaction().commit();

	}

	// Thêm mới sản phẩm
	public void insert(SanPham sanPham) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(sanPham);

		session.getTransaction().commit();

	}

	// lấy tất cả sản phẩm chưa xuất hóa đơn

	public List<SanPham> getAllNotHd() {
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM SanPham WHERE idsanpham NOT IN ( SELECT idsanpham FROM HoaDon)");

		return query.getResultList();
	}
	
	public List<SanPham> getAllNotHdId(int id){
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM SanPham WHERE (idsanpham NOT IN (SELECT idsanpham FROM HoaDon) OR idsanpham = :id)");

		query.setParameter("id", id);
		return query.getResultList();
	}
	//lấy tất cả sản phẩm chưa sử dụng
	public List<HopDong> getAllNotspsd(){
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM SanPham WHERE idsanpham NOT IN ( SELECT idsanpham FROM SPSuDung)");

		return query.getResultList();
	}

}
