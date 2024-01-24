package com.AntonioPNPereia.cinemamanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AntonioPNPereia.cinemamanagement.domain.Cinema;

@Service
public class CinemaServiceChecker {
	private CinemaService cinemaService;
	
	@Autowired
	public CinemaServiceChecker(final CinemaService cinemaService) {
		this.cinemaService = cinemaService;
	}
	
	@Autowired
	public void cinemaTester() {
		
		Cinema cinema = new Cinema()
				.name("Cinemas NOS Alameda Shop e Spot")
				.location("Rua dos Campeões Europeus, nº 28/ 198 Porto");
		cinemaService.createCinema(cinema);
	}
}
