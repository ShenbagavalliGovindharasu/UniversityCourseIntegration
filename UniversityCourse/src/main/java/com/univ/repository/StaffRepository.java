package com.univ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.entity.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

	//void findById(Long id, Staff newStaff);

}
