package com.shopping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopping.models.Admin;
import com.shopping.repository.AdminRepository;



@Service
public class AdminService implements UserDetailsService {
	public static final String getAdmin = null;
	@Autowired
	private AdminRepository adminRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Admin foundedAdmin = adminRepository.findByaEmail(username);

		if (foundedAdmin == null)
			return null;
		String aEmail = foundedAdmin.getaEmail();
		String aPassword = foundedAdmin.getaPassword();
		return new User(aEmail, aPassword, new ArrayList<>());
	}
   public List<Admin> getAdmin() {
		
		List<Admin> admin = adminRepository.findAll();
		System.out.println("Getting Users from DB" + admin);
		return admin;
	}

	



}
