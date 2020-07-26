package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.CustomerDetails;
import com.capgemini.exception.CustomerDetailsException;
import com.capgemini.service.CustomerDetailsService;

@RestController
public class CustomerDetailsController {
	
	@Autowired
	private CustomerDetailsService customerdetailsservice;
	
	@PostMapping("/addcustomerdetails")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<String> addcustomerdetails(@Valid @RequestBody CustomerDetails customerdetails , BindingResult br) throws CustomerDetailsException {
		String err = " ";
		if(br.hasErrors()) {
			List<FieldError> errors = br.getFieldErrors();
			for(FieldError error : errors)
				err += error.getDefaultMessage() + "<br/>";
			throw new CustomerDetailsException(err);
		}
		try {
			customerdetailsservice.addcustomerdetails(customerdetails);
			return new ResponseEntity<String>("Details added", HttpStatus.OK);
		}
		catch(DataIntegrityViolationException ex) {
			throw new CustomerDetailsException("Details not added");
		}
	}
}
