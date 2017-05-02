package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.jackson.JsonNodeValueReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.WinnerEntity;
import hu.unideb.inf.dandy.szd.service.dto.BreakEvent;
import hu.unideb.inf.dandy.szd.service.dto.DummyBreaker;
import hu.unideb.inf.dandy.szd.service.dto.Event;
import hu.unideb.inf.dandy.szd.service.dto.Gender;
import hu.unideb.inf.dandy.szd.service.dto.Role;
import hu.unideb.inf.dandy.szd.service.dto.SimpleEvent;
import hu.unideb.inf.dandy.szd.service.dto.Winner;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
		modelMapper.getConfiguration().addValueReader(new JsonNodeValueReader());
		modelMapper.createTypeMap(Role.class, Long.class).setConverter(new RoleConverter());
		modelMapper.createTypeMap(Gender.class, Long.class).setConverter(new GenderConverter());
		modelMapper.createTypeMap(Long.class, Role.class).setConverter(new RoleBackConverter());
		modelMapper.createTypeMap(BreakEvent.class, Event.class).setConverter(new BreakEventToEventConverter());
		modelMapper.createTypeMap(SimpleEvent.class, Event.class).setConverter(new SimpleEventToEventConverter());
		modelMapper.createTypeMap(WinnerEntity.class, Winner.class).setConverter(new WinnerEntityToWinnerConverter());
		modelMapper.createTypeMap(BreakerEntity.class, DummyBreaker.class).setConverter(new BreakerEntityToDummyBreakerConverter());
		
		return modelMapper;
	}
}
