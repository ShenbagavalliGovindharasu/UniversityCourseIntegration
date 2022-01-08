package com.univ.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.univ.entity.Course;
import com.univ.exception.ResourceNotFoundException;
import com.univ.repository.CourseRepository;

@RestController
@RequestMapping("/course")
public class CourseController {
	@Autowired
	public CourseRepository courseRepository;
	@GetMapping
public String msg() {
	return "hi";

}
	//localhost:8080/show
	@GetMapping("/show")
	public List<Course> getAllCourse(){
		return courseRepository.findAll();
	}
	//localhost:8088/addcourse
	@RequestMapping(value="/addcourse",method=RequestMethod.POST)
    public Course addCourse(@RequestBody Course course) {

        return courseRepository.save(course);
    }
	@RequestMapping(value="/update",method=RequestMethod.PUT)
    public Course updateCourse(@RequestBody Course course) {

        return courseRepository.save(course);
    }
	@RequestMapping(value="/deletebyid/{id}",method=RequestMethod.DELETE)
    public void  deleteCourse(@PathVariable("id") long id) {

    courseRepository.deleteById(id);

    }
	@RequestMapping(value="/coursebyid/{id}",method=RequestMethod.GET)
    public Course getProductById(@PathVariable("id") long id) {

        return courseRepository.findById(id).get();

    }
	
	@PutMapping("/updatebyid/{id}")
	public Course updateNote(@PathVariable(value = "id") Long courseId,
	                                        @Valid @RequestBody Course courseDetails) {

	    Course course = courseRepository.findById(courseId).orElseThrow(() -> new ResourceNotFoundException("Course not found in this"+courseId, "id", courseId));
;
		
	    course.setId(courseDetails.getId());
	    course.setCoursename(courseDetails.getCoursename());
	    course.setDuration(courseDetails.getDuration());
	    course.setEnddate(courseDetails.getEnddate());
	    course.setStartdate(courseDetails.getStartdate());
	    course.setCoursefee(courseDetails.getCoursefee());
	    Course updatedcourse = courseRepository.save(course);
	    return updatedcourse;
	}


}
