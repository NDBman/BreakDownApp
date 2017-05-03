package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.service.dto.Gender;

public class GenderBackConverter implements Converter<Long, Gender> {

	@Override
	public Gender convert(MappingContext<Long, Gender> context) {
		switch(context.getSource().intValue()){
		case 0: return Gender.MALE;
		case 1: return Gender.FEMALE;
		}
		return null;
	}

}
