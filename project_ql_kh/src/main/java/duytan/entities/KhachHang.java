package duytan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idkh;
	
	private String tenkh;
	
	private String diachikh;
	
	private String sodtkh;
	
	private String username;
	
	private String password;
	
	private int iddonvi;
	
	private int idbophan;

	public KhachHang() {
		super();
	}

	public KhachHang(int idkh, String tenkh, String diachikh, String sodtkh, String username, String password,
			int iddonvi, int idbophan) {
		super();
		this.idkh = idkh;
		this.tenkh = tenkh;
		this.diachikh = diachikh;
		this.sodtkh = sodtkh;
		this.username = username;
		this.password = password;
		this.iddonvi = iddonvi;
		this.idbophan = idbophan;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public String getTenkh() {
		return tenkh;
	}

	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}

	public String getDiachikh() {
		return diachikh;
	}

	public void setDiachikh(String diachikh) {
		this.diachikh = diachikh;
	}

	public String getSodtkh() {
		return sodtkh;
	}

	public void setSodtkh(String sodtkh) {
		this.sodtkh = sodtkh;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIddonvi() {
		return iddonvi;
	}

	public void setIddonvi(int iddonvi) {
		this.iddonvi = iddonvi;
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
