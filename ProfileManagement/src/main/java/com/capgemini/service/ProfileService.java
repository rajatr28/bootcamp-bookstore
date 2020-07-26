package com.capgemini.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.ProfileDao;
import com.capgemini.entity.Profile;

@Service
public class ProfileService {
	
	@Autowired
	private ProfileDao profiledao;
	
	@Transactional
	public Profile addprofile(Profile profile) {
		return profiledao.save(profile);
	}
	
	@Transactional
	public Optional<Profile> viewprofile(Integer profile_id){
		return profiledao.findById(profile_id);
	}
	
	public boolean updateprofile (Profile profile,Integer profile_id) {
		profile.setProfile_id(profile.getProfile_id());
		return profiledao.save(profile) != null;
		
	}

}
