package com.sample.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.transaction.annotation.Transactional;

/**
 * Represents a number.
 * 
 */
@Transactional
@Entity
@Table(name="number")
public class Num {

	/**
	 * Represents the literal value of the number.
	 * same as the identifier of table
	 */
	@Id @NotNull
	private int id;

	/**
	 * Creates a number with id=0
	 * 
	 */
	public Num(){}
	
	/**
	 * Creates a number with provided literal value.
	 * 
	 */
	public Num(@NotNull int id) {
		this.id = id;
	}	

	/**
	 * Get the value of number
	 * @return value
	 */
	public int getId() {
		return id;
	}

	 /**
	  * Changes the name of this Student.
	  * @param id This number's new value.  
	  */
	public void setId(int id) {
		this.id = id;
	}
	
	 /**
	  * Override toString() method to return id of number instead of it's address 
	  * @return String 
	  */
	@Override
	public String toString() {
		return "ID = " + id ;
	}

}
