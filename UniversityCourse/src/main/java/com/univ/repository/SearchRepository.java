package com.univ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.univ.entity.Course;

@Repository
//@EnableJpaRepositories
public interface SearchRepository extends JpaRepository<Course, Long> {
	
	@Query("select c from Course c where c.coursename = :coursename")
	public List<Course> findByCourseName(@Param("coursename") String courseName);


}
