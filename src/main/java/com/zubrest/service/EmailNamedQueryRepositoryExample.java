package com.zubrest.service;

import java.util.List;

import com.zubrest.domain.Email;
import org.springframework.data.repository.Repository;

public interface EmailNamedQueryRepositoryExample extends Repository<Email, Long> {
	// Query will be used from Named query defined at Entity class
	List<Email> findByAddress(String address);

}
