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

import duytan.entities.KhachHang;

@Repository
public class KhachHangDAO {
	@Autowired
	SessionFactory sessionFactory;

	// lấy tấu cả thông tin khách hàng theo table khachhang

	public List<KhachHang> getAll() {
		Session session = sessionFactory.openSession();

		List list = session.createQuery("from KhachHang").getResultList();

		session.close();
		return list;
	}

	// lấy tất cả thông tin khách hàng theo bảng đơn vị và bộ phận quản lý

	public List<Object> showALL(int page, int pagesize) {
		Session session = sessionFactory.openSession();

		String querysString = "SELECT kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh,  dv.tendonvi FROM KhachHang kh, LoaiDonVi dv WHERE kh.iddonvi = dv.iddonvi";

		Query query = session.createQuery(querysString);

		return query.setFirstResult((page - 1)* pagesize).setMaxResults(pagesize).getResultList();
	}

	// lấy khách hàng theo id với cấu trúc bảng khách hàng

	public KhachHang getById(int id) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		KhachHang khachHang = session.get(KhachHang.class, id);

		session.getTransaction().commit();

		return khachHang;
	}
	// lấy khách hàng theo id với cấu trúc bảng khách hàng và đơn vị và bộ phận

	public List<Object> getById2(int id) {

		Session session = sessionFactory.openSession();

		String querysString = "SELECT kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh, kh.username, kh.password, dv.tendonvi, bp.tenbophan FROM KhachHang kh, LoaiDonVi dv, BoPhanQL bp WHERE kh.iddonvi = dv.iddonvi AND kh.idbophan = bp.idbophan AND kh.idkh = :id";

		Query query = session.createQuery(querysString);

		query.setParameter("id", id);

		return query.getResultList();
	}

	// cập nhạt thông tin khách hàng

	public void update(KhachHang khachHang) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.update(khachHang);

		session.getTransaction().commit();

	}

	// Xóa khách hàng

	public void delete(int id) {
		
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		
		var kh = session.get(KhachHang.class, id);
		
		session.remove(kh);
		
		session.getTransaction().commit();
		
	}
	
	//thêm mới khách hàng
	public void insert(KhachHang khachHang) {

		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();

		session.save(khachHang);

		session.getTransaction().commit();

	}
	
	
	// dem khách hàng đã hết hạn bảo trì
	public int countkhachHangHetHanBaoTri(String date, int iddichvu,  int page, int pagesize) {

		Session session = sessionFactory.openSession();
		
		Date date1 = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			date1 = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 String querysString = "";
		 
		 if(iddichvu == 0) {
			 
			 querysString = "select kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh, dv.tendonvi, dvu.tendichvu,   hd.ngayhethan, hd.ngayky from KhachHang kh, HopDong hd , LoaiDonVi dv, LoaiDichVu dvu where kh.idkh = hd.idkh and kh.iddonvi = dv.iddonvi and hd.iddichvu = dvu.iddichvu and  hd.ngayhethan < :date1";
		 }
		 
		 else {
			 querysString = "select kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh, dv.tendonvi, dvu.tendichvu,   hd.ngayhethan, hd.ngayky from KhachHang kh, HopDong hd , LoaiDonVi dv, LoaiDichVu dvu where kh.idkh = hd.idkh and kh.iddonvi = dv.iddonvi and hd.iddichvu = dvu.iddichvu and hd.iddichvu = :iddichvu and  hd.ngayhethan < :date1";
		 }

		
		 
		Query query = session.createQuery(querysString);
		
		if(iddichvu == 0) {
			 query.setParameter("date1", date1);
		 }
		else {
			query.setParameter("date1", date1);
			
			query.setParameter("iddichvu", iddichvu);
		}

		

		return query.getResultList().size();
	}
	
	//Tìm khách hàng đã hết hạn bảo trì
		public List<Object> khachHangHetHanBaoTri(String date, int iddichvu) {

			Session session = sessionFactory.openSession();
			
			Date date1 = new Date();
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			 try {
				date1 = formatter.parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			 String querysString = "";
			 
			 if(iddichvu == 0) {
				 
				 querysString = "select kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh, dv.tendonvi, dvu.tendichvu,   hd.ngayhethan, hd.ngayky from KhachHang kh, HopDong hd , LoaiDonVi dv, LoaiDichVu dvu where kh.idkh = hd.idkh and kh.iddonvi = dv.iddonvi and hd.iddichvu = dvu.iddichvu and  hd.ngayhethan < :date1";
			 }
			 
			 else {
				 querysString = "select kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh, dv.tendonvi, dvu.tendichvu,   hd.ngayhethan, hd.ngayky from KhachHang kh, HopDong hd , LoaiDonVi dv, LoaiDichVu dvu where kh.idkh = hd.idkh and kh.iddonvi = dv.iddonvi and hd.iddichvu = dvu.iddichvu and hd.iddichvu = :iddichvu and  hd.ngayhethan < :date1";
			 }

			
			 
			Query query = session.createQuery(querysString);
			
			if(iddichvu == 0) {
				 query.setParameter("date1", date1);
			 }
			else {
				query.setParameter("date1", date1);
				
				query.setParameter("iddichvu", iddichvu);
			}

			

			return query.getResultList();
		}
	
	//Tìm khách hàng theo thông tiêu chí
	public List<Object> search_kh(String tenkh, String diachikh, String sodtkh) {
		Session session = sessionFactory.openSession();

		//trường hợp tìm cả 3 tiêu chí
		String querysString = "SELECT kh.idkh, kh.tenkh, kh.diachikh, kh.sodtkh,  dv.tendonvi FROM KhachHang kh INNER JOIN LoaiDonVi dv ON kh.iddonvi = dv.iddonvi WHERE kh.tenkh like :tenkh and kh.diachikh like :diachikh and kh.sodtkh like :sodtkh";

		Query query = session.createQuery(querysString);
		
		query.setParameter("tenkh", "%"+tenkh+"%");
		query.setParameter("diachikh", "%"+diachikh+"%");
		query.setParameter("sodtkh", "%"+sodtkh+"%");

		return query.getResultList();
	}
	
	public int count() {
		Session session = sessionFactory.openSession();
		int result = session.createQuery("from KhachHang").list().size();
		return result;
	}
	
}
