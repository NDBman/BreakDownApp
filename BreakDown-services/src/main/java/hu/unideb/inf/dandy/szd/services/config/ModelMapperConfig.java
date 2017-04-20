package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.jackson.JsonNodeValueReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hu.unideb.inf.dandy.szd.service.dto.Gender;
import hu.unideb.inf.dandy.szd.service.dto.Role;

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
		return modelMapper;
	}
}
