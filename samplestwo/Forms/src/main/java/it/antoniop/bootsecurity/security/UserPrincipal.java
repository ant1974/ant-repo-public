package it.antoniop.bootsecurity.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.antoniop.bootsecurity.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {
    
	private static final long serialVersionUID = 1L;
	
	private User user;

    public UserPrincipal(User user){
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

		if (this.user != null) {
	        // Extract list of permissions (name)
	        this.user.getPermissionList().forEach(p -> {
	            GrantedAuthority authority = new SimpleGrantedAuthority(p);
	            authorities.add(authority);
	        });
	
	        // Extract list of roles (ROLE_name)
	        this.user.getRoleList().forEach(r -> {
	            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
	            authorities.add(authority);
	        });
		}
		
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
		if (this.user == null) {
			return false;
		}
        return this.user.getActive() == 1;
    }
}
