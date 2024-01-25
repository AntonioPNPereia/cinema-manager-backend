package com.AntonioPNPereia.cinemamanagement.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.AntonioPNPereia.cinemamanagement.domain.Cinema;
import com.AntonioPNPereia.cinemamanagement.service.CinemaService;


@RestController
public class CinemaController {
	
	private final CinemaService cinemaService;
	
	public CinemaController(final CinemaService cinemaService) {
		this.cinemaService = cinemaService;
	}

	@RequestMapping(value = "/cinema/{cinemaId}",
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.GET)
	
	@GetMapping("/cinema/{cinemaId}")
	ResponseEntity<Cinema> getCinema(@PathVariable final long cinemaId) {
	    return ResponseEntity.ok(cinemaService.getCinema(cinemaId));
	}

}
