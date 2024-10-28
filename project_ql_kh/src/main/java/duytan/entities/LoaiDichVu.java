package duytan.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaidichvu")
public class LoaiDichVu implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddichvu;
	
	private String tendichvu;

	public LoaiDichVu(int iddichvu, String tendichvu) {
		super();
		this.iddichvu = iddichvu;
		this.tendichvu = tendichvu;
	}

	public LoaiDichVu() {
		super();
	}

	public int getIddichvu() {
		return iddichvu;
	}

	public void setIddichvu(int iddichvu) {
		this.iddichvu = iddichvu;
	}

	public String getTendichvu() {
		return tendichvu;
	}

	public void setTendichvu(String tendichvu) {
		this.tendichvu = tendichvu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
