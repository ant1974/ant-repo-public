package it.antoniop.bootsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final String AUTH_ACCESS_TEST2 = "ACCESS_TEST2";

	private static final String AUTH_ACCESS_TEST1 = "ACCESS_TEST1";

	private static final String MANAGER_ROLE = "MANAGER";

	private static final String ADMIN_ROLE = "ADMIN";
    
	private UserPrincipalDetailsService userPrincipalDetailsService;

    public SecurityConfiguration(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index.html").permitAll()
                .antMatchers("/profile/**").authenticated()
                .antMatchers("/admin/**").hasRole(ADMIN_ROLE)
                .antMatchers("/management/**").hasAnyRole(ADMIN_ROLE, MANAGER_ROLE)
                .antMatchers("/api/public/test1").hasAuthority(AUTH_ACCESS_TEST1)
                .antMatchers("/api/public/test2").hasAuthority(AUTH_ACCESS_TEST2)
                .antMatchers("/api/public/users").hasRole(ADMIN_ROLE)
/*    */        .antMatchers("/actuator/**").hasRole(ADMIN_ROLE)  /*    */
                .and()
                .formLogin()
                .loginProcessingUrl("/signin")
/* * /          .defaultSuccessUrl("/profile/index") / * */   // default if NOT indicated   is  .defaultSuccessUrl("/index")
                .loginPage("/login").permitAll()     
/* * /          .failureUrl("/auth-failed")          / * */   // default if NOT indicated   is  .failureUrl("/login?error=true")
                .usernameParameter("txtUsername")
                .passwordParameter("txtPassword")
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .rememberMe().tokenValiditySeconds(2592000).key("mySecret!").rememberMeParameter("checkRememberMe"); // 2592000 seconds = 30 days 
        
    }

    //  ... @Bean because of DbInit ... class
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService);

        return daoAuthenticationProvider;
    }


    //  ... @Bean because of DbInit ... class      
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
}
