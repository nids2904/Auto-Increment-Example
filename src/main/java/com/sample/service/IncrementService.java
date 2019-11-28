package com.sample.service;

import java.util.List;

import javax.transaction.Transactional;

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
	private volatile NumRepository numbers;

	/**
	 * method to increment the only record-value of number table by 1 
	 * @throws InvalidNumberOfValuesException, NoValueException
	 *  
	 */
	@Transactional
	public void updateValue() throws InvalidNumberOfValuesException, NoValueException{
		List<Num> numList=numbers.findAll();
		if(numList.isEmpty()){
			throw new NoValueException();
		}else if(numList.size()!=1){
			throw new InvalidNumberOfValuesException();
		}else{
			synchronized(this){
				int currentValue = numList.get(0).getId();
				System.out.println("curValue="+currentValue);
				numbers.deleteById(currentValue);
				int newValue = currentValue+1;
				System.out.println("newValue="+newValue);
				numbers.saveAndFlush(new Num(newValue));
			}
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
			return numList.get(0).toString();
		}
	}



}
