package com.capgemini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.CustomerDetails;

@Repository
public interface CustomerDetailsDao extends JpaRepository<CustomerDetails , Integer>{

}
