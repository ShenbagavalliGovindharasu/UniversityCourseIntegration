package com.univ.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.univ.model.Applicant;

import java.util.List;
import java.util.Optional;


@Repository
public interface UpdateRepository extends JpaRepository<Applicant, Integer> {

	@Query(value = "SELECT applicant_status FROM applicant" , nativeQuery = true)
	List<Applicant> getapplicant_status();

	static Applicant getCaughtException(Integer num) {
		int result = 100/num;
		
		Applicant applicant = new Applicant();
		applicant.setStatus(result);
		return applicant;
		
	}

	static Optional<Applicant> findById(long l) {
		
		return Optional.of(UpdateRepository.findById(1L).get());
	}

	

	

}