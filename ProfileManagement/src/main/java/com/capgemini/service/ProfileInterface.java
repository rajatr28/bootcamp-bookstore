package com.capgemini.service;

import java.util.Optional;

import com.capgemini.entity.Profile;

public interface ProfileInterface {
	public boolean addProfile(Profile profile_id);
	public Profile updateprofile(Profile profile);
	public Optional<Profile> viewprofile(Integer profile_id);

}
