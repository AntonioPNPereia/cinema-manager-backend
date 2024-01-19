package com.AntonioPNPereia.cinemamanagement.service;

import com.AntonioPNPereia.cinemamanagement.domain.Cinema;
import com.AntonioPNPereia.cinemamanagement.repository.CinemaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {
	private final CinemaRepository cinemaRepository;
	
    @Autowired
    public CinemaService(final CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }
    
    
    
   /**
    * Create Cinema.
    * @param cinema cinema.
    * @return cinema created.
    */
   public Cinema createCinema(final Cinema cinema){
       final Optional<Cinema> cinemaOptional = cinemaRepository.findCinemaByName(cinema.getName());
       if(cinemaOptional.isEmpty()){
           return cinemaRepository.save(cinema);
       }
       throw new NullPointerException("Error: Cinema already exists!");
   }
   
   /**
    * Get Cinema.
    * @param cinemaId cinema id.
    * @return cinema retrieved.
    */
   public Cinema getCinema(final long cinemaId){
       final Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
       if(cinemaOptional.isEmpty()){
           throw new NullPointerException("Error: Cinema to get does not exist!");
       }
       return cinemaOptional.get();
   }

   /**
    * Edit Cinema.
    * @param cinemaId cinema id.
    * @param cinemaEdited cinema edited.
    * @return cinema edited.
    */
   public Cinema editCinema(final long cinemaId,  final Cinema cinemaEdited){
       final Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
       if(cinemaOptional.isEmpty()){
           throw new NullPointerException("Error: Cinema to be edited does not exist!");
       }
       //edit cinema
       cinemaOptional.get()
               .name(cinemaEdited.getName())
               .location(cinemaEdited.getLocation());

       return cinemaRepository.save(cinemaOptional.get());
   }

   /**
    * Delete Cinema.
    * @param cinemaId cinema id.
    * @return cinema deleted.
    */
   public Cinema deleteCinema(final long cinemaId){
       final Optional<Cinema> cinemaOptional = cinemaRepository.findById(cinemaId);
       if(cinemaOptional.isEmpty()){
           throw new NullPointerException("Error: Cinema to be deleted does not exists!");
       }
       cinemaRepository.deleteById(cinemaId);
       return cinemaOptional.get();
   }

   /**
    * Get All Cinemas.
    * @return List of cinemas.
    */
   public List<Cinema> getAllCinemas(){
       final List<Cinema> cinemaList = cinemaRepository.findAll();
       if(cinemaList.isEmpty()){
           throw new NullPointerException("Error: No Cinemas found!");
       }
       return cinemaList;
   }
}
