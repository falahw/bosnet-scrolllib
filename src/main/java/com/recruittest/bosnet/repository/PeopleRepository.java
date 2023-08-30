package com.recruittest.bosnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.recruittest.bosnet.model.People;

public interface PeopleRepository extends JpaRepository<People, String> {

}
