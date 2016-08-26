package com.ryde.rm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ryde.rm.domain.Rental;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

	
}
