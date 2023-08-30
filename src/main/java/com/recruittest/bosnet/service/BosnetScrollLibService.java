package com.recruittest.bosnet.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.recruittest.bosnet.model.People;

public interface BosnetScrollLibService {

	List<People> getAllPeople();
	People getPeopleById(String id);
	Page<People> findPaginated(int pageNo, int pageSize, String sortField, String sortAscOrDesc);
}
