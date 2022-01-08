package com.univ.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univ.Exception.CourseNotFoundException;
import com.univ.entity.Course;
import com.univ.service.CourseService;


@RestController
@RequestMapping("/search")
public class SearchController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
	public String display() {
		return "wecome";
	}
	
	@GetMapping("/coursename/{courseName}")
	public ResponseEntity<List<Course>> getAllCourseByName(@PathVariable("courseName")String courseName) throws CourseNotFoundException{
		
		System.out.println("In method.....");
		List<Course>course= courseService.findByCourseName(courseName);
		if(course.isEmpty())
		{
		return new ResponseEntity("Sorry! cannot find such course.....try something else!", HttpStatus.NOT_FOUND);
		}
		else if(courseService.findByCourseName(courseName).isEmpty()) 
	      {
			throw new CourseNotFoundException("No course is exist in name:" +courseName);
		  }
      else{ 
    		return new ResponseEntity<List<Course>>(course, HttpStatus.OK);	
  		  }
		
	}
	
	
}
