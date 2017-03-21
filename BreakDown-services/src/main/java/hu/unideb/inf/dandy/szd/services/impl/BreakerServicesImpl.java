package hu.unideb.inf.dandy.szd.services.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.Breaker;
import hu.unideb.inf.dandy.szd.jpa.entity.Rank;
import hu.unideb.inf.dandy.szd.jpa.repo.BreakerRepository;
import hu.unideb.inf.dandy.szd.services.BreakerServices;
import hu.unideb.inf.dandy.szd.services.GenderServices;
import hu.unideb.inf.dandy.szd.services.feedback.FeedbackCodes;

@Service
public class BreakerServicesImpl implements BreakerServices{


	@Autowired
	private BreakerRepository breakerRepository;
	
	@Autowired
	private GenderServices genderServices;
	
	private DateFormatter dateFormatter = new DateFormatter("yyyy/MM/dd");
	
	public List<FeedbackCodes> createBreaker(String name,String bname, String password, String passwordAgain, String birthday, Long gender) throws ParseException{
		List<FeedbackCodes> feedback = new ArrayList<>();
		if(!password.equals(passwordAgain)){
			feedback.add(FeedbackCodes.NOT_MATCHING_PASSWORDS);
		}
		if(breakerRepository.findByBboyName(bname) != null){
			feedback.add(FeedbackCodes.USERNAME_ALREADY_EXIST);
		}
		if(feedback.isEmpty()){
			Breaker newBreaker = new Breaker();
			newBreaker.setName(name);
			newBreaker.setBboyName(bname);
			newBreaker.setPassword(password);
			newBreaker.setRank(Rank.USER);
			newBreaker.setBirthday(dateFormatter.parse(birthday, Locale.ENGLISH));
			newBreaker.setGender(genderServices.getGender(gender));
			newBreaker.setEnabled(true);
			breakerRepository.save(newBreaker);
			return Arrays.asList(FeedbackCodes.PASS);
		} else {
			return feedback;
		}
	}
	
	
}
