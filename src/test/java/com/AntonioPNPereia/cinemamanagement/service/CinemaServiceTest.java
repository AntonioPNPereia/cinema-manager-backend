package com.AntonioPNPereia.cinemamanagement.service;

import com.AntonioPNPereia.cinemamanagement.domain.*;
import com.AntonioPNPereia.cinemamanagement.repository.CinemaRepository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;



@RunWith(MockitoJUnitRunner.class)
public class CinemaServiceTest {

	@InjectMocks
	CinemaService cinemaService;
	
	@Mock
	CinemaRepository cinemaRepository;
	
	@Test
	public void CinemaAlreadyExists_thrownAnException() {
		// Cinema that is passed
		Cinema cinemaPassed = new Cinema()
				.name("Cinemas NOS Alameda Shop e Spot")
				.location("Rua dos Campeões Europeus, nº 28/ 198 Porto");
		
		//Return cinema that was passed, therefore it already exists.
		Mockito.when(cinemaRepository.findCinemaByName(cinemaPassed.getName())).thenReturn(Optional.of(cinemaPassed));
		
		//Then
		Assert.assertThrows(NullPointerException.class,() -> cinemaService.createCinema(cinemaPassed));
		
	}
	
	@Test
	public void CinemaDoesNotExists_returnCinemaSaved() {
	    // Cinema that is passed
	    Cinema cinemaPassed = new Cinema()
	            .name("Cinemas NOS Alameda Shop e Spot")
	            .location("Rua dos Campeões Europeus, nº 28/ 198 Porto");

	    // Return empty, therefore it doesn't exist
	    Mockito.when(cinemaRepository.findCinemaByName(cinemaPassed.getName())).thenReturn(Optional.empty());
	    // Save and return the cinema
	    Mockito.when(cinemaRepository.save(cinemaPassed)).thenReturn(cinemaPassed);

	    Cinema savedCinema = cinemaService.createCinema(cinemaPassed);
	    
	    // Then
	    Assert.assertEquals(cinemaPassed, savedCinema);
	}

	
	@Test
	public void EditCinema_returnedEditedCinema() {
		
	    // Create a cinema to edit
	    Cinema cinemaToEdit = new Cinema()
	            .name("Old Cinema Name")
	            .location("Old Cinema Location");
	    cinemaToEdit.setId(10L);

	    // Create the edited cinema
	    Cinema cinemaEdited = new Cinema()
	            .name("New Cinema Name")
	            .location("New Cinema Location");

	    // Return cinema to be edited
	    Mockito.when(cinemaRepository.findById(cinemaToEdit.getId())).thenReturn(Optional.of(cinemaToEdit));
	    Mockito.when(cinemaRepository.save(cinemaToEdit)).thenReturn(cinemaEdited);
	    
	    Cinema editedCinema = cinemaService.editCinema(cinemaToEdit.getId(), cinemaEdited);
	    
	    Mockito.verify(cinemaRepository).findById(cinemaToEdit.getId());
	    Mockito.verify(cinemaRepository).save(cinemaToEdit);
	    
	    Assert.assertEquals(cinemaEdited, editedCinema);
	}

	
	@Test
	public void DeleteCinemaById_thrownAnException() {

	    Long cinemaIdToDelete = 10L;

	    Mockito.when(cinemaRepository.findById(cinemaIdToDelete)).thenReturn(Optional.empty());
	    Assert.assertThrows(NullPointerException.class, () -> cinemaService.deleteCinema(cinemaIdToDelete));
	}
}
