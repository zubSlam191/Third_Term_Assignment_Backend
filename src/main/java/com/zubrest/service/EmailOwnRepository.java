package com.zubrest.service;

import java.util.Date;
import java.util.List;

import com.zubrest.domain.Email;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

public interface EmailOwnRepository extends Repository<Email,Long>{
	@Query(value="select date from Email b where b.date=?1")
	List<Email> findByAddress(String address);
	List<Email> findByAddressAndDate(String name, Date date);
}
