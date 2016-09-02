package com.zubrest.service;

import java.util.Date;
import java.util.List;

import com.zubrest.domain.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface EmailQueryRepositoryExample extends Repository<Email, Long> {
	
	@Query(value = "select * from #{#entityName} b where b.address=?1", nativeQuery = true)
	List<Email> findByAddress(String address);

	@Query(value = "select address, description, date  from Email b where b.date=?1")
	List<Email> findByDate(Date date);

}
