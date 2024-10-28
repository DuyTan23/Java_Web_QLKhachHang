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

import duytan.entities.HopDong;

@Repository
public class HopDongDAO {

	@Autowired
	SessionFactory sessionFactory;

	public List<HopDong> getAll() {
		Session session = sessionFactory.openSession();

		List list = session.createQuery("from HopDong ").getResultList();

		return list;
	}

//lấy tất cả hợp đồng theo cấu trúc tự định nghĩa
	public List<Object> showAll(int page, int pagesize) {
		Session session = sessionFactory.openSession();

		String string = "select hd.idhopdong, kh.tenkh, dv.tendichvu, hd.ngayky, hd.ngayhethan, hd.hientranghdon  from HopDong hd, KhachHang kh, LoaiDichVu dv where hd.idkh = kh.idkh and hd.iddichvu = dv.iddichvu";

		Query query = session.createQuery(string);

		return query.setFirstResult((page - 1) * pagesize).setMaxResults(pagesize).getResultList();
	}

//tìm hợp đồng theo tình trạng háo đơn
	public List<Object> serchHd(String tinhtranghh) {

		boolean b = Boolean.parseBoolean(tinhtranghh);

		Session session = sessionFactory.openSession();

		String string = "select hd.idhopdong, kh.tenkh, dv.tendichvu, hd.ngayky, hd.ngayhethan, hd.hientranghdon  from HopDong hd, KhachHang kh, LoaiDichVu dv where hd.idkh = kh.idkh and hd.iddichvu = dv.iddichvu and  hd.hientranghdon = :b";

		Query query = session.createQuery(string);

		query.setParameter("b", b);

		return query.getResultList();
	}

	// tìm hợp đồng theo tình trạng háo đơn
	public List<Object> serchHd1(int iddichvu, String tenkh) {

		Session session = sessionFactory.openSession();

		String string = "select hd.idhopdong, kh.tenkh, dv.tendichvu, hd.ngayky, hd.ngayhethan, hd.hientranghdon  from HopDong hd, KhachHang kh, LoaiDichVu dv where hd.idkh = kh.idkh and hd.iddichvu = dv.iddichvu  and hd.iddichvu = :iddichvu and kh.tenkh like :tenkh ";

		Query query = session.createQuery(string);

		query.setParameter("iddichvu", iddichvu);
		query.setParameter("tenkh", "%" + tenkh + "%");

		return query.getResultList();
	}

	public List<Object> serchHd2(String tenkh) {

		Session session = sessionFactory.openSession();

		String string = "select hd.idhopdong, kh.tenkh, dv.tendichvu, hd.ngayky, hd.ngayhethan, hd.hientranghdon  from HopDong hd, KhachHang kh, LoaiDichVu dv where hd.idkh = kh.idkh and hd.iddichvu = dv.iddichvu  and kh.tenkh like :tenkh ";

		Query query = session.createQuery(string);

		query.setParameter("tenkh", "%" + tenkh + "%");

		return query.getResultList();
	}

	public List<Object> serchHd3(String ngaybatdau, String ngayketthuc) {

		Session session = sessionFactory.openSession();
		
		boolean b = false;
		
		Date date1 = new Date();//ngày bắt đầu
		
		Date date2 = new Date();//ngày kết thúc

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			
			date1 = formatter.parse(ngaybatdau);
			date2 = formatter.parse(ngayketthuc);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String	string = "select hd.idhopdong, kh.tenkh, dv.tendichvu, hd.ngayky, hd.ngayhethan, hd.hientranghdon  from HopDong hd, KhachHang kh, LoaiDichVu dv where hd.idkh = kh.idkh and hd.iddichvu = dv.iddichvu   and hd.ngayhethan <= :date2 and  hd.ngayhethan >= :date1  and  hd.hientranghdon = :b";

		

		Query query = session.createQuery(string);
		
		
		query.setParameter("date1",date1);
		
		query.setParameter("date2",date2);
		
		query.setParameter("b", b);
	


		return query.getResultList();
	}
	
	//lay hop dong theo id voi cau truc tu dinh nghia
	
	public Object getByid(int idhopdong) {
		
		Session session = sessionFactory.openSession();
		
		String string = "select hd.idhopdong,  kh.tenkh, dv.tendichvu, hd.motasanpham, hd.ngayky, hd.ngayhethan, hd.giatri, hd.hientranghdon from HopDong hd, LoaiDichVu dv, KhachHang kh where hd.idkh = kh.idkh and hd.iddichvu = dv.iddichvu and hd.idhopdong = :idhopdong";
	
		Query query = session.createQuery(string);
		
		query.setParameter("idhopdong", idhopdong);
		
		return query.getSingleResult();
	}

	// Lấy hợp đồng theo id
	public HopDong getById2(int id) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		
		HopDong hopDong = session.get(HopDong.class, id);
		
		session.getTransaction().commit();

		return hopDong;
	}

	// Thêm mới hợp đồng
	
	public void insert(HopDong hopDong) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(hopDong);

		session.getTransaction().commit();

	}
	

	// cập nhật hợp đồng
	public void update(HopDong hopDong) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.update(hopDong);

		session.getTransaction().commit();

	}

	// xóa hợp đồng
	public void delete(int id) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		
		var hopdong = session.get(HopDong.class, id);

		session.remove(hopdong);

		session.getTransaction().commit();

	}
	
	//lấy tất cả hợp đồng chưa xuất hóa đơn
	
	public List<HopDong> getAllNotHd(){
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM HopDong WHERE idhopdong NOT IN ( SELECT idhopdong FROM HoaDon)");

		return query.getResultList();
	}
	//lấy tất cả hợp đồng chưa được xuất hóa đơn ngoai trừ hợp đồng hiện tại
	public List<HopDong> getAllNotHdId(int id){
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("FROM HopDong WHERE (idhopdong NOT IN (SELECT idhopdong FROM HoaDon) OR idhopdong = :id)");

		query.setParameter("id", id);
		return query.getResultList();
	}
	
	public int count() {
		Session session = sessionFactory.openSession();
		int result = session.createQuery("from HopDong").list().size();
		return result;
	}
}
