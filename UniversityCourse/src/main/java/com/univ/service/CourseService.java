package com.univ.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.univ.entity.Course;


@Service
public interface CourseService {
	
	public List<Course> findByCourseName(String crName);
}
