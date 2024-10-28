package duytan.entities.account;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="accounts")
public class Account {
	@Id 
	@Column(name = "accountid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountid;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String passWord;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "avatar")
	private String avatar;
	
	
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	private Set<AccountRole> accountroles;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Account(String userName, String passWord, String fullName, String avatar) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.fullName = fullName;
		this.avatar = avatar;
	}



	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Set<AccountRole> getAccountroles() {
		return accountroles;
	}

	public void setAccountroles(Set<AccountRole> accountroles) {
		this.accountroles = accountroles;
	}
	
}
