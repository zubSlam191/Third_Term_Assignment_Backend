package com.zubrest.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zubrest.domain.Email;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {
	@Autowired
	private EmailRepository emailRepository;
	@Autowired
	private EmailOwnRepository emailOwnRepository;
	@Autowired
	private EmailQueryRepositoryExample emailQueryRepository;
	@Autowired
	private EmailNamedQueryRepositoryExample emailNamedQueryRepository;

	public List<Email> findAll() {
		return emailRepository.findAll();
	}

	public List<Email> findByAddress(String address) {
		return emailQueryRepository.findByAddress(address);
	}

	public List<Email> findByDate(Date date) {
		return emailQueryRepository.findByDate(date);
	}

	public List<Email> findByAddressAndDate(String address, Date date) {
		return emailOwnRepository.findByAddressAndDate(address, date);
	}

	public void saveEmail(Email email) {
		emailRepository.save(email);
	}

	public Email findOne(long id) {
		System.out.println("Cached Pages");
		return emailRepository.findOne(id);
	}

	public void delete(long id) {
		emailRepository.delete(id);
	}
}
