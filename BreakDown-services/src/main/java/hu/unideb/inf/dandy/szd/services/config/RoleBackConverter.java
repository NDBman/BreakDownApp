package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.service.dto.Role;

public class RoleBackConverter implements Converter<Long, Role> {

	@Override
	public Role convert(MappingContext<Long, Role> context) {
		switch (context.getSource().intValue()) {
		case 0:
			return Role.USER;
		case 1:
			return Role.ORGANIZER;
		case 2:
			return Role.ADMIN;
		}
		return null;
	}

}
