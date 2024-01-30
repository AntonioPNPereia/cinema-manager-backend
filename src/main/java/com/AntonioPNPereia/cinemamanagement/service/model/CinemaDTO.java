package com.AntonioPNPereia.cinemamanagement.service.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CinemaDTO implements Serializable{
	
	@JsonProperty("id")
    private long id;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("location")
    private String location;
	
	/**
     * Get Cinema id.
     * @return cinema id.
     */
    public long getId() { return id; }
    
    /**
     * Set Cinema id.
     * @param id cinema id.
     */
    public void setId(long id) {this.id = id;}
    
    /**
     * Get Cinema name.
     * @return cinema name.
     */
    public String getName() { return name; }
    
    /**
     * Set Cinema name.
     * @param name cinema name.
     */
    public void setName(String name) {this.name = name;}
    
    /**
     * Get Cinema id.
     * @return cinema id.
     */
    public String getLocation() { return location; }
    
    /**
     * Set Cinema location.
     * @param Location cinema location.
     */
    public void setLocation(String location) {this.location = location;}
    

}
