package com.univ.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.univ.entity.Course;
import com.univ.repository.SearchRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	
	@Autowired
	public SearchRepository searchRepository;
	
	@Override
	public List<Course> findByCourseName(String crName) {
		List<Course> cr=searchRepository.findByCourseName(crName);//custom methods of repository
		return cr;
	}
	
	}


