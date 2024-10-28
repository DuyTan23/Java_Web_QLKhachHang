package duytan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "bophanql")
public class BoPhanQL implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idbophan;
	
	private String tenbophan;

	public BoPhanQL() {
		super();
	}

	public BoPhanQL(int idbophan, String tenbophan) {
		super();
		this.idbophan = idbophan;
		this.tenbophan = tenbophan;
	}

	public int getIdbophan() {
		return idbophan;
	}

	public void setIdbophan(int idbophan) {
		this.idbophan = idbophan;
	}

	public String getTenbophan() {
		return tenbophan;
	}

	public void setTenbophan(String tenbophan) {
		this.tenbophan = tenbophan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
