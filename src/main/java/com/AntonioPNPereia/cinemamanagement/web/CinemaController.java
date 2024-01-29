package com.AntonioPNPereia.cinemamanagement.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.AntonioPNPereia.cinemamanagement.domain.Cinema;
import com.AntonioPNPereia.cinemamanagement.service.CinemaService;


@RestController
public class CinemaController {
	
	private final CinemaService cinemaService;
	
	public static final String CINEMA_ID_PATH = "/cinema/{cinemaId}";
	public static final String CINEMA_PATH = "/cinema";
	
	
	public CinemaController(final CinemaService cinemaService) {
		this.cinemaService = cinemaService;
	}
	
	//Get Cinema by ID
	@RequestMapping(value = CINEMA_ID_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.GET)
	
	@GetMapping(CINEMA_ID_PATH)
	ResponseEntity<Cinema> getCinema(@PathVariable final long cinemaId) {
	    return ResponseEntity.ok(cinemaService.getCinema(cinemaId));
	}
	
	// Create Cinema
	@RequestMapping(value = CINEMA_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.POST)
	
	@PostMapping(CINEMA_PATH)
	ResponseEntity<Cinema> createCinema(@RequestBody final Cinema cinema) {
	    return ResponseEntity.ok(cinemaService.createCinema(cinema));
	}
	
	//Edit cinema 
	@RequestMapping(value = CINEMA_ID_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.PUT)
	
	@PutMapping(CINEMA_ID_PATH)
	ResponseEntity<Cinema> editCinema(@PathVariable final long cinemaId, @RequestBody final Cinema cinema) {
	    return ResponseEntity.ok(cinemaService.editCinema(cinemaId, cinema));
	}
	
	//Delete cinema 
	@RequestMapping(value = CINEMA_ID_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.DELETE)
	
	@DeleteMapping(CINEMA_ID_PATH)
	ResponseEntity<Cinema> deleteCinema(@PathVariable final long cinemaId) {
	    return ResponseEntity.ok(cinemaService.deleteCinema(cinemaId));
	}

}
