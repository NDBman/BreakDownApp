package hu.unideb.inf.dandy.szd.services.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hu.unideb.inf.dandy.szd.jpa.config.BreakDownJpaModulConfig;

@Configuration
@ComponentScan(basePackages={"hu.unideb.inf.dandy.szd.services"})
@Import(BreakDownJpaModulConfig.class)
public class BreakDownServiceModuleConfig {

}
