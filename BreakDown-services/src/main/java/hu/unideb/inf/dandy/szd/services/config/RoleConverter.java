package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.service.dto.Role;

public class RoleConverter implements Converter<Role, Long> {

	@Override
	public Long convert(MappingContext<Role, Long> context) {
		switch (context.getSource()) {
		case USER:
			return 0L;
		case ORGANIZER:
			return 1L;
		case ADMIN:
			return 2L;
		}
		return null;
	}

}
