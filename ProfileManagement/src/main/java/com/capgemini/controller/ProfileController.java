package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.Profile;
import com.capgemini.exception.ProfileException;
import com.capgemini.service.ProfileService;

@RestController
public class ProfileController {
	
	@Autowired
	private ProfileService profileservice;
	
	@PostMapping("/addprofile")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> addprofile(@Valid @RequestBody Profile profile , BindingResult br) throws ProfileException {
		String err = " ";
		if(br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new ProfileException(err);
		}
		try {
			profileservice.addprofile(profile);
			return new ResponseEntity<String>("Profile added", HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex) {
			throw new ProfileException("Profile not added");
		}
	}
	
	@PutMapping("/updateprofile/{profile_id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity updateprofile(@Valid @RequestBody Profile profile,@PathVariable Integer profile_id,BindingResult br ) throws ProfileException
	{
		String err = " ";
		if(br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new ProfileException(err);
		}
		try {
			profileservice.updateprofile(profile, profile_id);
			return new ResponseEntity<String> ("Updation Complete", HttpStatus.OK);
		}
		catch (DataIntegrityViolationException ex) {
			throw new ProfileException("Profile ID not found");
		}
	}
	
	@GetMapping("/getprofile/{profile_id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<Profile> viewprofile(@PathVariable Integer profile_id) throws ProfileException{
		try {
			return profileservice.viewprofile(profile_id);
		}
		catch(Exception ex) {
			throw new ProfileException(ex.getMessage());
		}
	}

}
