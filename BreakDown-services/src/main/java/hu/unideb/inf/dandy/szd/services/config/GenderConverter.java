package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.service.dto.Gender;

public class GenderConverter implements Converter<Gender, Long> {

	@Override
	public Long convert(MappingContext<Gender, Long> context) {
		switch(context.getSource()){
		case MALE: return 0L;
		case FEMALE: return 1L;
		}
		return null;
	}

}
