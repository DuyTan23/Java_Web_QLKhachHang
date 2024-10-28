package duytan.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sanpham")
public class SanPham implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idsanpham;
	
	@Column(name = "tensamphan")
	private String tensanpham;
	
	private String kihieu ;
	
	private String tinhtrang;
	
	private int idbophan;

	public SanPham(int idsanpham, String tensanpham, String kihieu, String tinhtrang, int idbophan) {
		super();
		this.idsanpham = idsanpham;
		this.tensanpham = tensanpham;
		this.kihieu = kihieu;
		this.tinhtrang = tinhtrang;
		this.idbophan = idbophan;
	}

	public SanPham() {
		super();
	}

	public int getIdsanpham() {
		return idsanpham;
	}

	public void setIdsanpham(int idsanpham) {
		this.idsanpham = idsanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getKihieu() {
		return kihieu;
	}

	public void setKihieu(String kihieu) {
		this.kihieu = kihieu;
	}

	public String getTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(String tinhtrang) {
		this.tinhtrang = tinhtrang;
	}

	public int getIdbophan() {
		return idbophan;
	}

	public void setIdbophan(int idbophan) {
		this.idbophan = idbophan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
