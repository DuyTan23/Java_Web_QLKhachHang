package duytan.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import duytan.entities.HoaDon;
import duytan.entities.HopDong;

@Repository
public class HoaDonDAO {
	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	HopDongDAO hopDongDAO;

	// lấy thông tin hóa đơn
	public List<Object> showAll(int page, int pagesize) {
		Session session = sessionFactory.openSession();
		String String = "select hdon.idhoadon,  sp.tensanpham, hd.giatri, bp.tenbophan, hdon.ngayxuat, hdon.hientrang, hdon.ngaythanhtoan from HoaDon hdon , HopDong hd, SanPham sp, BoPhanQL bp where hdon.idhopdong = hd.idhopdong and hdon.idsanpham = sp.idsanpham and hdon.idbophan = bp.idbophan";
		Query query = session.createQuery(String);
		return query.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();
	}

	public List<Object> searchThanhToan(String tinhtrang) {

		boolean b = Boolean.parseBoolean(tinhtrang);

		Session session = sessionFactory.openSession();

		String String = "select hdon.idhoadon,  sp.tensanpham, hd.giatri, bp.tenbophan, hdon.ngayxuat, hdon.hientrang, hdon.ngaythanhtoan from HoaDon hdon , HopDong hd, SanPham sp, BoPhanQL bp where hdon.idhopdong = hd.idhopdong and hdon.idsanpham = sp.idsanpham and hdon.idbophan = bp.idbophan and hdon.hientrang = :b";

		Query query = session.createQuery(String);

		query.setParameter("b", b);

		return query.getResultList();
	}

	public List<Object> searchThanhToanngay(String date) {

		boolean b = false;

		Date date1 = new Date();// ngay ky

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {

			date1 = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Session session = sessionFactory.openSession();

		String String = "select hdon.idhoadon,  sp.tensanpham, hd.giatri, bp.tenbophan, hdon.ngayxuat, hdon.hientrang, hdon.ngaythanhtoan from HoaDon hdon , HopDong hd, SanPham sp, BoPhanQL bp where hdon.idhopdong = hd.idhopdong and hdon.idsanpham = sp.idsanpham and hdon.idbophan = bp.idbophan and hdon.hientrang = :b and hdon.ngayxuat <= :date1";

		Query query = session.createQuery(String);

		query.setParameter("b", b);
		query.setParameter("date1", date1);

		return query.getResultList();
	}

	public List<HoaDon> getAll() {
		Session session = sessionFactory.openSession();

		List list = session.createQuery("from HoaDon").getResultList();

		return list;
	}

	// Thêm hóa đơn mới
	public void insert(HoaDon hoaDon) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(hoaDon);

		session.getTransaction().commit();
		
		//khi trạo hóa đơn hơp đồng tương ứng tự động cập nhật hiện trạng hóa đơn thành đã xuất
		int idhopdong = hoaDon.getIdhopdong();
		HopDong hopDong = hopDongDAO.getById2(idhopdong);
		hopDong.setHientrangdon(true);
		hopDongDAO.update(hopDong);

	}

	// cập nhật hó đơn
	public void update(HoaDon hoaDon) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.update(hoaDon);

		session.getTransaction().commit();

	}

	// lấy hóa đơn theo id
	public HoaDon getById(int id) {
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		HoaDon hoaDon = session.get(HoaDon.class, id);

		session.getTransaction().commit();

		return hoaDon;
	}

	// Xóa hóa đơn
	public void delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		var hoaDon = session.get(HoaDon.class, id);
		
		session.remove(hoaDon);

		session.getTransaction().commit();

	}
	
	public int count() {
		Session session = sessionFactory.openSession();
		int result = session.createQuery("from HoaDon").list().size();
		return result;
	}

}
