package duytan.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "spsudung")
public class SPSuDung implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private int idkh;
	
	@Id
	private int idsanpham;
	
	//@Temporal(TemporalType.DATE)
	
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private String ngayhoatdong;
	
	

	public SPSuDung() {
		super();
	}

	public SPSuDung(int idkh, int idsanpham, String ngayhoatdong) {
		super();
		this.idkh = idkh;
		this.idsanpham = idsanpham;
		this.ngayhoatdong = ngayhoatdong;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public int getIdsanpham() {
		return idsanpham;
	}

	public void setIdsanpham(int idsanpham) {
		this.idsanpham = idsanpham;
	}

	public String getNgayhoatdong() {
		return ngayhoatdong;
	}

	public void setNgayhoatdong(String ngayhoatdong) {
		this.ngayhoatdong = ngayhoatdong;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
