package hu.unideb.inf.dandy.szd.services;

import hu.unideb.inf.dandy.szd.jpa.entity.WinnerEntity;
import hu.unideb.inf.dandy.szd.service.dto.Winner;

public interface WinnerService {

	Winner saveWinner(WinnerEntity winnerEntity);
}
