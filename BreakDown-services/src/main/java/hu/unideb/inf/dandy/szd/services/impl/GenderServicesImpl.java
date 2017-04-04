package hu.unideb.inf.dandy.szd.services.impl;

import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.GenderEntity;
import hu.unideb.inf.dandy.szd.services.GenderServices;

@Service
public class GenderServicesImpl implements GenderServices{

	@Override
	public GenderEntity getGender(Long id) {
		if(id==1L)
			return GenderEntity.MALE;
		else
			return GenderEntity.FEMALE;
	}

}
