package com.recruittest.bosnet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.recruittest.bosnet.model.People;
import com.recruittest.bosnet.repository.PeopleRepository;

@Service
public class BosnetScrollLibServiceImpl implements BosnetScrollLibService {

	@Autowired
	private PeopleRepository repDAO;

	@Override
	public List<People> getAllPeople() {
		// TODO Auto-generated method stub
		return repDAO.findAll(); //return null;
	}

	@Override
	public People getPeopleById(String id) {
		// TODO Auto-generated method stub
		Optional<People> optPpl = repDAO.findById(id);
		People ppl = null;
		
		if (optPpl.isPresent()) {
			ppl = optPpl.get();
		} else {
			throw new RuntimeException("People is not found for ID: " + id);
		}
		
		return ppl; //return null;
	}

	@Override
	public Page<People> findPaginated(int pageNo, int pageSize, String sortField, String sortAscOrDesc) {
		// TODO Auto-generated method stub
		Sort runut = sortAscOrDesc.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
		
		Pageable pagable = PageRequest.of(pageNo - 1, pageSize, runut);
		
		return this.repDAO.findAll(pagable); //return null;
	}
}
