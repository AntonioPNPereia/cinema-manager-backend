package com.AntonioPNPereia.cinemamanagement.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.AntonioPNPereia.cinemamanagement.service.CinemaService;
import com.AntonioPNPereia.cinemamanagement.service.mapper.CinemaMapper;
import com.AntonioPNPereia.cinemamanagement.service.model.CinemaDTO;


@RestController
public class CinemaController {
	
	private final CinemaService cinemaService;
	private final CinemaMapper cinemaMapper;
	
	public static final String CINEMA_ID_PATH = "/cinema/{cinemaId}";
	public static final String CINEMA_PATH = "/cinema";
	
	
	public CinemaController(final CinemaService cinemaService, final CinemaMapper cinemaMapper) {
		this.cinemaService = cinemaService;
		this.cinemaMapper = cinemaMapper;
	}
	
	//Get Cinema by ID
	@RequestMapping(value = CINEMA_ID_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.GET)
	
	@GetMapping(CINEMA_ID_PATH)
	ResponseEntity<CinemaDTO> getCinema(@PathVariable final long cinemaId) {
	    return ResponseEntity.ok(cinemaMapper.mapCinemaToCinemaDTO(cinemaService.getCinema(cinemaId)));
	}
	
	// Create Cinema
	@RequestMapping(value = CINEMA_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.POST)
	
	@PostMapping(CINEMA_PATH)
	ResponseEntity<CinemaDTO> createCinema(@RequestBody final CinemaDTO cinemaDTO) {
	    return ResponseEntity.ok(cinemaMapper.mapCinemaToCinemaDTO(
	    		cinemaService.createCinema(cinemaMapper.mapCinemaDTOtoCinema(cinemaDTO))));
	}
	
	//Edit cinema 
	@RequestMapping(value = CINEMA_ID_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.PUT)
	
	@PutMapping(CINEMA_ID_PATH)
	ResponseEntity<CinemaDTO> editCinema(@PathVariable final long cinemaId, @RequestBody final CinemaDTO cinemaDTO) {
	    return ResponseEntity.ok(cinemaMapper.mapCinemaToCinemaDTO(
	    		cinemaService.editCinema(cinemaId, cinemaMapper.mapCinemaDTOtoCinema(cinemaDTO))));
	}
	
	//Delete cinema 
	@RequestMapping(value = CINEMA_ID_PATH,
			produces = {"application/json"},
			consumes = {"application/json"},
			method = RequestMethod.DELETE)
	
	@DeleteMapping(CINEMA_ID_PATH)
	ResponseEntity<CinemaDTO> deleteCinema(@PathVariable final long cinemaId) {
	    return ResponseEntity.ok(cinemaMapper.mapCinemaToCinemaDTO(cinemaService.deleteCinema(cinemaId)));
	}

}
