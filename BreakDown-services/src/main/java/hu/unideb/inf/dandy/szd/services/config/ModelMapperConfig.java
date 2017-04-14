package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
		modelMapper.createTypeMap(Role.class, Long.class).setConverter(new RoleConverter());
		modelMapper.createTypeMap(Gender.class, Long.class).setConverter(new GenderConverter());
		return modelMapper;
	}
}