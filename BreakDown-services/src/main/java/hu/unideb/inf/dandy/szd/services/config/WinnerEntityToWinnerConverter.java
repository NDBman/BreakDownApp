package hu.unideb.inf.dandy.szd.services.config;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import hu.unideb.inf.dandy.szd.jpa.entity.WinnerEntity;
import hu.unideb.inf.dandy.szd.service.dto.Winner;

public class WinnerEntityToWinnerConverter implements Converter<WinnerEntity, Winner>{

	@Override
	public Winner convert(MappingContext<WinnerEntity, Winner> context) {
		Winner winner = new Winner();
		winner.setWinnerId(context.getSource().getWinnerId());
		winner.setWinnerUsername(context.getSource().getWinnerUsername());
		winner.setWinnedCompetitionName(context.getSource().getWinnedCompetitionName());
		winner.setWinnedCompetitionId(context.getSource().getWinnedCompetitionId());
		winner.setDescription(context.getSource().getDescription());
		return winner;
	}

}
