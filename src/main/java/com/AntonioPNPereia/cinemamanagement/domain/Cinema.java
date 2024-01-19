package com.AntonioPNPereia.cinemamanagement.domain;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "cinema")
public class Cinema {
    @Id
    @GenericGenerator(name = "increment", strategy = "increment")
    @GeneratedValue(generator = "increment")
    private long id;

    @Column(name = "name")
    private String name;
   
    @Column(name = "location")
    private String location;
       
    public Cinema() {
    	
    }
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
     * Builder Cinema for name.
     * @param name name to build.
     * @return cinema with name.
     */
    public Cinema name(final String name){
        this.name = name;
        return this;
    }
    
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
    
    /**
     * Builder Cinema for location
     * @param location location to build.
     * @return cinema with location.
     */
    public Cinema location(final String location){
        this.location = location;
        return this;
    }
    
    
}