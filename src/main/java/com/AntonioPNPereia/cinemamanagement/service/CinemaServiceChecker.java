package com.AntonioPNPereia.cinemamanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceChecker {
	private CinemaService cinemaService;
	
	@Autowired
	public CinemaServiceChecker(final CinemaService cinemaService) {
		this.cinemaService = cinemaService;
	}
	
	@Autowired
	public void cinemaTester() {
	
	}
}
