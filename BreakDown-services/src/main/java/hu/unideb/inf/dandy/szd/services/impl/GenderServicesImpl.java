package hu.unideb.inf.dandy.szd.services.impl;

import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.service.dto.Gender;
import hu.unideb.inf.dandy.szd.services.GenderServices;

@Service
public class GenderServicesImpl implements GenderServices{

	@Override
	public Gender getGender(Long id) {
		if(id==0L)
			return Gender.MALE;
		else if((id == 1L))
			return Gender.FEMALE;
		return Gender.MALE;
	}

}
