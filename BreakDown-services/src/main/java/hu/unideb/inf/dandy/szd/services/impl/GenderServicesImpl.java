package hu.unideb.inf.dandy.szd.services.impl;

import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.Gender;
import hu.unideb.inf.dandy.szd.services.GenderServices;

@Service
public class GenderServicesImpl implements GenderServices{

	@Override
	public Gender getGender(Long id) {
		if(id==1L)
			return Gender.MALE;
		else
			return Gender.FEMALE;
	}

}
