package duytan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaidonvi")
public class LoaiDonVi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int iddonvi;
	
	private String tendonvi;

	public LoaiDonVi() {
		super();
	}

	public LoaiDonVi(int iddonvi, String tendonvi) {
		super();
		this.iddonvi = iddonvi;
		this.tendonvi = tendonvi;
	}

	public int getIddonvi() {
		return iddonvi;
	}

	public void setIddonvi(int iddonvi) {
		this.iddonvi = iddonvi;
	}

	public String getTendonvi() {
		return tendonvi;
	}

	public void setTendonvi(String tendonvi) {
		this.tendonvi = tendonvi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
