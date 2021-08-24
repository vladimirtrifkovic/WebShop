package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.example.demo.model.Buyer;
import com.example.demo.model.Role;
import com.example.demo.repository.BuyerRepository;
import com.example.demo.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE )
@Rollback(false)
class UsertTestApplication {
	
		@Autowired
		RoleRepository roleRepository;

		@Autowired
		private BuyerRepository repo;
		
		@Autowired
		private TestEntityManager entityManager;
		
//		@Autowired
//		private BCryptPasswordEncoder encoder;
		
		@Test
		public void listRoles() {
			List<Role> listRoles = roleRepository.findAll();
			assertThat(listRoles.size()).isEqualTo(4);
		}
		
		@Test
		public void testCreatingUser() {
			Buyer u = new Buyer();
			u.setEmail("vtrifkov1@gmail.com");
			u.setFirstName("Vladimir1");
			u.setLastName("Trifkovic1");
			u.setPassword("vlado123");
			
			Buyer savedUser = repo.save(u);
			
			Buyer existsUser = entityManager.find(Buyer.class, savedUser.getId());
			assertThat(existsUser.getEmail()).isEqualTo(u.getEmail());
		}
//		Naknadna provjera po mail adresi
		@Test
		public void testFindUserByEmail() {
			String email = "pera1@pera1.com";
			
			Buyer user = repo.findByEmail(email);
			assertThat(user).isNotNull();
			
		}
		
		@Test
		public void testAddingRoleToUser() {
			Buyer u = new Buyer();
			u.setEmail("vtrifkov2@gmail.com");
			u.setFirstName("Vladimir2");
			u.setLastName("Trifkovic2");
			u.setPassword("vlado123");
			u.setAddress("vladimir bb");
			u.setPhone("065610762");
			u.setEnabled(true);
			
			Role roleUser = roleRepository.findByName("USER");
			u.addRole(roleUser);
			
			Buyer buyer = repo.save(u);
			
			assertThat(buyer.getRoles().size()).isEqualTo(1);
		}
		
		@Test
		public void addRoleToExistingUser() {
			Buyer buyer = repo.findById(27).get(); 
			
			Role roleUser = roleRepository.findByName("ADMIN");
			buyer.addRole(roleUser);
			
			assertThat(buyer.getRoles().size()).isEqualTo(2);
			
		}

	}