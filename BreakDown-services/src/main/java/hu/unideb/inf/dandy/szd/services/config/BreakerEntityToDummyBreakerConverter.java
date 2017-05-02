package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.jpa.entity.BreakerEntity;
import hu.unideb.inf.dandy.szd.jpa.entity.WinnerEntity;
import hu.unideb.inf.dandy.szd.service.dto.DummyBreaker;
import hu.unideb.inf.dandy.szd.service.dto.Role;
import hu.unideb.inf.dandy.szd.service.dto.Winner;

public class BreakerEntityToDummyBreakerConverter implements Converter<BreakerEntity, DummyBreaker> {

	@Override
	public DummyBreaker convert(MappingContext<BreakerEntity, DummyBreaker> context) {
		DummyBreaker dummy = new DummyBreaker();
		dummy.setName(context.getSource().getName());
		dummy.setUsername(context.getSource().getUsername());
		dummy.setId(context.getSource().getId());
		dummy.setEmail(context.getSource().getEmail());
		if (context.getSource().getWins() != null) {
			for (WinnerEntity we : context.getSource().getWins()) {
				Winner winner = new Winner();
				winner.setWinnerUsername(we.getWinnerUsername());
				winner.setWinnedCompetitionId(we.getWinnedCompetitionId());
				winner.setDescription(we.getDescription());
				winner.setWinnerId(we.getWinnerId());
				winner.setWinnedCompetitionName(we.getWinnedCompetitionName());
				System.out.println(winner.getWinnedCompetitionId() + " " + winner.getWinnedCompetitionName());
				dummy.getWins().add(winner);
			}
		}
		switch (context.getSource().getRole().intValue()) {
		case 0:
			dummy.setRole(Role.USER);
			break;
		case 1:
			dummy.setRole(Role.ORGANIZER);
			break;
		case 2:
			dummy.setRole(Role.ADMIN);
			break;
		}
		if (dummy.getRole().equals(Role.ORGANIZER)) {
			dummy.setOrganizer(true);
		} else {
			dummy.setOrganizer(false);
		}
		return dummy;
	}

}
