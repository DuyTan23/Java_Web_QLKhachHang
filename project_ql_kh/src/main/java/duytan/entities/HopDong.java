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
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "hopdong")
public class HopDong implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idhopdong;
	
	private int idkh;
	
	private int iddichvu;
	
	private String motasanpham ;
	
	@Temporal(TemporalType.DATE)

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayky;
	
	@Temporal(TemporalType.DATE)

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	
	private Date ngayhethan;
	
	@NumberFormat(pattern = "0.0")
	private float giatri;
	
	private boolean hientranghdon;
	
	private String ghichu;
 

	public HopDong(int idhopdong, int idkh, int iddichvu, String motasanpham, Date ngayky, Date ngayhethan,
			float giatri, boolean hientrangdon, String ghichu) {
		super();
		this.idhopdong = idhopdong;
		this.idkh = idkh;
		this.iddichvu = iddichvu;
		this.motasanpham = motasanpham;
		this.ngayky = ngayky;
		this.ngayhethan = ngayhethan;
		this.giatri = giatri;
		this.hientranghdon = hientrangdon;
		this.ghichu = ghichu;
	}

	public HopDong() {
		super();
	}

	public int getIdhopdong() {
		return idhopdong;
	}

	public void setIdhopdong(int idhopdong) {
		this.idhopdong = idhopdong;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public int getIddichvu() {
		return iddichvu;
	}

	public void setIddichvu(int iddichvu) {
		this.iddichvu = iddichvu;
	}

	public String getMotasanpham() {
		return motasanpham;
	}

	public void setMotasanpham(String motasanpham) {
		this.motasanpham = motasanpham;
	}

	public Date getNgayky() {
		return ngayky;
	}

	public void setNgayky(Date ngayky) {
		this.ngayky = ngayky;
	}

	public Date getNgayhethan() {
		return ngayhethan;
	}

	public void setNgayhethan(Date ngayhethan) {
		this.ngayhethan = ngayhethan;
	}

	public float getGiatri() {
		return giatri;
	}

	public void setGiatri(float giatri) {
		this.giatri = giatri;
	}

	public boolean isHientrangdon() {
		return hientranghdon;
	}

	public void setHientrangdon(boolean hientrangdon) {
		this.hientranghdon = hientrangdon;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getDisplayLabel() {
        return this.idhopdong + " (" + this.motasanpham + ")";
    }


	
	
	
}
