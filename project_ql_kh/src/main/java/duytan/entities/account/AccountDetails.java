package duytan.entities.account;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//Lớp customzie userdetails để chứa đầy đủ thông tin người dùng
public class AccountDetails implements UserDetails {
	
	private Collection<? extends GrantedAuthority> authorities;

	private String fullName;
	private String password;
	private String username;
	private String avatar;
	private boolean enabled;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;

	public AccountDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AccountDetails(Collection<? extends GrantedAuthority> authorities,  String fullName,
			String password, String username,  String avatar,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired) {
		super();
		this.authorities = authorities;
		this.fullName = fullName;
		this.password = password;
		this.username = username;
		this.avatar = avatar;
		this.enabled = true;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}



	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}




	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}


	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}


	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	

}
