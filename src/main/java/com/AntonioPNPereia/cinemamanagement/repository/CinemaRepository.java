package com.AntonioPNPereia.cinemamanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.AntonioPNPereia.cinemamanagement.domain.Cinema;

import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long>, JpaSpecificationExecutor<Cinema> {
    /**
     * Get Cinema by name
     * @param name cinema name
     * @return cinema as optional
     */
    Optional<Cinema> findCinemaByName(String name);

}