package com.sample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.dao.Num;
import com.sample.dao.NumRepository;
import com.sample.exception.InvalidNumberOfValuesException;
import com.sample.exception.NoValueException;

/**
 * Represents service which is used for processing controller's requests 
 * 
 */
@Service
public class IncrementService {

	/**
	 * Represents repository of number objects
	 * 
	 */
	@Autowired
	private NumRepository numbers;
	
	/**
	  * method to increment the only record-value of number table by 1 
	  * @throws InvalidNumberOfValuesException, NoValueException
	  * @return String 
	  */
	public synchronized String updateValue() throws InvalidNumberOfValuesException, NoValueException{
		List<Num> numList=numbers.findAll();
		if(numList.isEmpty()){
			throw new NoValueException();
		}else if(numList.size()!=1){
			throw new InvalidNumberOfValuesException();
		}else{
			Num previousNumber =  numList.get(0);
			int currentValue = previousNumber.getId();
			numbers.deleteById(currentValue);
			numbers.flush();
			Num currentNumber = new Num(currentValue+1);
			numbers.save(currentNumber);
			numbers.flush();
			return currentNumber.toString();
		}	
	}

	/**
	  * method to get the only record-value of number table
	  * @throws InvalidNumberOfValuesException, NoValueException
	  * @return String 
	  */
	public String getValue() throws InvalidNumberOfValuesException, NoValueException {
		List<Num> numList=numbers.findAll();
		if(numList.isEmpty()){
			throw new NoValueException();
		}else if(numList.size()!=1){
			throw new InvalidNumberOfValuesException();
		}else{
			Num currentNumber =  numList.get(0);
			return currentNumber.toString();
		}

	}
	 
	/**
	  * method to reset table with only one record whose id is 0 
	  * @return String 
	  */
	public String resetDAO() {
		numbers.deleteAll();
		numbers.flush();
		numbers.save(new Num(0));
		numbers.flush();
		return "Value restored to 0.";
	}

}
