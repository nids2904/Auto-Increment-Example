package com.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Represents repository of number-objects
 *
 */
@Repository
public interface NumRepository extends JpaRepository<Num, Integer> {

}
