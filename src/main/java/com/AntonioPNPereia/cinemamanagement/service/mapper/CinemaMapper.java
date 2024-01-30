package com.AntonioPNPereia.cinemamanagement.service.mapper;

import org.mapstruct.*;

import com.AntonioPNPereia.cinemamanagement.domain.Cinema;
import com.AntonioPNPereia.cinemamanagement.service.model.CinemaDTO;

@Mapper(componentModel = "spring")
public interface CinemaMapper {
	
	Cinema mapCinemaDTOtoCinema(CinemaDTO cinemaDTO);
	CinemaDTO mapCinemaToCinemaDTO(Cinema cinema);
}