package duytan.services;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import duytan.dao.account.AccountDAO;
import duytan.entities.account.Account;
import duytan.entities.account.AccountDetails;
import duytan.entities.account.AccountRole;

@Service
public class AccountDetailsService implements UserDetailsService {
	@Autowired 
	private AccountDAO accountDAO;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getAccount(username);
	}
	//Lấy thông tin chi tiết của tài khoản người dùng theo username
	private AccountDetails getAccount(String username) {
		Account acc = accountDAO.get(username);
        if (acc==null){
            return null;
        }
        //xử lý lấy roles của người dùng đưa vào Authority
        Collection<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<AccountRole> roles = acc.getAccountroles();
        for (AccountRole accountRole : roles) {
        	String rolename=accountRole.getRole().getRolename();
        	System.out.println(rolename);
        	grantedAuthoritySet.add(new SimpleGrantedAuthority(rolename));
		}
        return new AccountDetails(grantedAuthoritySet,  acc.getFullName(), acc.getPassWord(), acc.getUserName(), acc.getAvatar(),true,true,true);
	}

}
