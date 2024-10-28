package duytan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "hoadon")
public class HoaDon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhoadon;
	
	private int idhopdong;
	
	private int idsanpham;
	
	private int idbophan;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayxuat;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngaythanhtoan;
	
	private boolean hientrang;

	public HoaDon(int idhoadon, int idhopdong, int idsanpham, int idbophan, Date ngayxuat, Date ngaythanhtoan,
			boolean hientrang) {
		super();
		this.idhoadon = idhoadon;
		this.idhopdong = idhopdong;
		this.idsanpham = idsanpham;
		this.idbophan = idbophan;
		this.ngayxuat = ngayxuat;
		this.ngaythanhtoan = ngaythanhtoan;
		this.hientrang = hientrang;
	}

	public HoaDon() {
		super();
	}

	public int getIdhoadon() {
		return idhoadon;
	}

	public void setIdhoadon(int idhoadon) {
		this.idhoadon = idhoadon;
	}

	public int getIdhopdong() {
		return idhopdong;
	}

	public void setIdhopdong(int idhopdong) {
		this.idhopdong = idhopdong;
	}

	public int getIdsanpham() {
		return idsanpham;
	}

	public void setIdsanpham(int idsanpham) {
		this.idsanpham = idsanpham;
	}

	public int getIdbophan() {
		return idbophan;
	}

	public void setIdbophan(int idbophan) {
		this.idbophan = idbophan;
	}

	public Date getNgayxuat() {
		return ngayxuat;
	}

	public void setNgayxuat(Date ngayxuat) {
		this.ngayxuat = ngayxuat;
	}

	public Date getNgaythanhtoan() {
		return ngaythanhtoan;
	}

	public void setNgaythanhtoan(Date ngaythanhtoan) {
		this.ngaythanhtoan = ngaythanhtoan;
	}

	public boolean isHientrang() {
		return hientrang;
	}

	public void setHientrang(boolean hientrang) {
		this.hientrang = hientrang;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
}
