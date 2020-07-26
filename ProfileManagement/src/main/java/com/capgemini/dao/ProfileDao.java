package com.capgemini.dao;

import org.springframework.stereotype.Repository;

import com.capgemini.entity.Profile;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProfileDao extends JpaRepository<Profile , Integer>{

}
