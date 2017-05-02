package hu.unideb.inf.dandy.szd.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.unideb.inf.dandy.szd.jpa.entity.WinnerEntity;
import hu.unideb.inf.dandy.szd.jpa.repo.WinnerRepository;
import hu.unideb.inf.dandy.szd.service.dto.Winner;
import hu.unideb.inf.dandy.szd.services.WinnerService;

@Service
public class WinnerServiceImpl implements WinnerService{

	@Autowired
	private WinnerRepository winnerRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public Winner saveWinner(WinnerEntity winnerEntity) {
		winnerEntity = winnerRepository.save(winnerEntity);
		return modelMapper.map(winnerEntity, Winner.class);
	}

	
}
