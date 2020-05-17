package it.antoniop.basicauthsec.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.antoniop.basicauthsec.model.User;

import java.util.Arrays;
import java.util.List;

/**
 *  CommandLineRunner Interface is an Interface used to indicate that a bean should run when it is contained 
 *  within a SpringApplication. 
 *	Multiple CommandLineRunner beans can be defined within the same application context and can be ordered using 
 *	the Ordered interface or @Order annotation. 
 *  
 */
@Service
public class DbInit implements CommandLineRunner {

    @Autowired
	private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.userRepository.deleteAll();

        // Create users
        User ant = new User("ant",passwordEncoder.encode("ant123"),"USER","");
        User admin = new User("admin",passwordEncoder.encode("admin123"),"ADMIN","ACCESS_TEST1,ACCESS_TEST2");
        User manager = new User("manager",passwordEncoder.encode("manager123"),"MANAGER","ACCESS_TEST1");

		List<User> users = Arrays.asList(new User[] { ant, admin, manager });

        // Save to db
        this.userRepository.saveAll(users);
    }
}
