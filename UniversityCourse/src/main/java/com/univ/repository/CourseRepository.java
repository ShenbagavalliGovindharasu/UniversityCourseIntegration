package com.univ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.univ.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {


	

	Object findCourserById(Long courseId);

}
