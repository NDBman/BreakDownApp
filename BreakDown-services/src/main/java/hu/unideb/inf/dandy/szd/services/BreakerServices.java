package hu.unideb.inf.dandy.szd.services;

import java.text.ParseException;
import java.util.List;

import hu.unideb.inf.dandy.szd.services.feedback.FeedbackCodes;

public interface BreakerServices {

	public List<FeedbackCodes> createBreaker(String name, String bname, String password,String passwordAgain, String birthday, Long gender) throws ParseException;
}
