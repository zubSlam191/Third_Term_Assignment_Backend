package com.zubrest.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.zubrest.domain.Email;
import com.zubrest.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/emails")
public class EmailController {
	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/add/{id}/{address}/{description}/{date}")
	public Email addEmail(@PathVariable int id, @PathVariable String address, @PathVariable String description,
						  @PathVariable String date) {

		DateFormat df = new SimpleDateFormat("MM_dd_yyyy");
		Date dateAfter = null;
		try {
			dateAfter = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Email email = new Email();
		email.setId(id);
		email.setAddress(address);
		email.setDescription(description);
		email.setDate(dateAfter);
		emailService.saveEmail(email);
		return email;
	}
	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		Email email = new Email();
		email.setId(id);
		emailService.delete(id);
	}
	@RequestMapping(value = "/")
	public List<Email> getEmails() {
		return emailService.findAll();
	}
	@RequestMapping(value = "/{id}")
	public Email getEmail(@PathVariable int id) {
		Email email = emailService.findOne(id);
		return email;
	}
	@RequestMapping(value = "/search/address/{address}")
	public List<Email> getEmailByAddress(@PathVariable String address) {
		List<Email> emails = emailService.findByAddress(address);
		return emails;
	}

	@RequestMapping(value = "/search/date/{date}")
	public List<Email> getBookByDate(@PathVariable String date) {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy");
		Date dateAfter = null;
		try {
			dateAfter = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		List<Email> emails = emailService.findByDate(dateAfter);
		return emails;
	}

	@RequestMapping(value = "/search/{address}/{date}")
	public List<Email> getBookByAddressAndDate(@PathVariable String address, @PathVariable String date) {
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy");
		Date dateAfter = null;
		try {
			dateAfter = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		List<Email> emails = emailService.findByAddressAndDate(address, dateAfter);
		return emails;
	}
}
