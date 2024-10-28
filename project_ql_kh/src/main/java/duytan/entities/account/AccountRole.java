package duytan.entities.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import duytan.entities.Role;

@Entity
@Table(name="accounts_roles")
public class AccountRole {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "accountId")
	private Account account;
	@ManyToOne
	@JoinColumn(name = "roleId")
	private Role role;
	
	public AccountRole() {
		// TODO Auto-generated constructor stub
	}
	
	

	public AccountRole(Account account, Role role) {
		super();
		this.account = account;
		this.role = role;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
