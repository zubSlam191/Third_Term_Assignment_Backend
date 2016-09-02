package com.zubrest.service;

import java.util.Date;
import java.util.List;

import com.zubrest.domain.Email;
import org.springframework.cache.annotation.Cacheable;

public interface EmailService {
	public List<Email> findAll();
	public void saveEmail(Email email);
	
	@Cacheable ("emails")
	public Email findOne(long id);
	public void delete(long id);
	public List<Email> findByAddress(String address);
	public List<Email> findByDate(Date date);
	public List<Email> findByAddressAndDate(String name, Date date);
}
