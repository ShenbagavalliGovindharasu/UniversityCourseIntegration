package com.univ;
/*
 * import org.junit.jupiter.api.Test; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * @SpringBootTest class UniversityCourseApplicationTests {
 * 
 * @Test void contextLoads() { }
 * 
 * }
 */
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.awt.PageAttributes.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.*;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.BDDMockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.univ.entity.Course;
import com.univ.repository.CourseRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class UniversityCourseApplicationTests {
	
	
	@MockBean
	CourseRepository crepo;
	
	@Test
	void contextLoads() {
	}
	
	//adding staff details test
	@Test
	public void testinsertCourse() throws Exception {
		Course s=new Course();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateInString1 = "2022-01-05 00:12:00";
		String dateInString2 = "2022-01-15 00:12:00";
		Date startdate = sdf.parse(dateInString2);
		Date enddate = sdf.parse(dateInString1);
		
		s.setId(155L);
		s.setCoursefee("500");
		s.setCoursename("Mech");
		s.setDuration("4 years");
		s.setEnddate(enddate);
		s.setStartdate(startdate);
		
		
		when(crepo.save(s)).thenReturn(s);
		assertThat(crepo.save(s)).isEqualTo(s);
		
		
	}
	 //view all course
	  
	  @Test 
	  public void getAllCourse() 
	  { 
		  List<Course> course=new ArrayList();
	  course.add(new Course()); 
	  given(crepo.findAll()).willReturn(course);
	  List<Course> expected = crepo.findAll(); 
	  assertEquals(expected, course);
	  verify(crepo).findAll();
	  
	  }
	  
	  
	  
	  //delete course using id
	  
	  @Test 
	  public void deleteCoursebyId() throws Exception 
	  { 
	  Course course= new Course();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String dateInString1 = "2022-01-05 00:12:00";
		String dateInString2 = "2022-01-15 00:12:00";
		Date startdate = sdf.parse(dateInString2);
		Date enddate = sdf.parse(dateInString1);
	  course.setId(114L);
	  course.setCoursefee("500");
	  course.setCoursename("EEE");
	  course.setEnddate(enddate);
	  course.setStartdate(startdate);
	  
	  when(crepo.findById(course.getId())).thenReturn(Optional.of(course));
	  crepo.deleteById(course.getId()); 
	  verify(crepo).deleteById(course.getId()); 
	  }
	  
	  @Test
		public void find_no_course_if_repo_is_empty() {
			Iterable<Course> course = crepo.findAll();

			assertThat(course).isEmpty();
		}
	  
//	  @Test
//	  public void should_update_course_by_id() throws Exception {
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//			String dateInString1 = "2022-01-05 00:12:00";
//			String dateInString2 = "2022-01-15 00:12:00";
//			Date startdate = sdf.parse(dateInString2);
//			Date enddate = sdf.parse(dateInString1);
//	    Course tut1 = new Course("EEE", "30 minutes",startdate, enddate,"500");
//	    entityManager.persist(tut1);
//	    Course tut2 = new Course("EEE", "30 minutes",startdate, enddate,"800");
//	    entityManager.persist(tut1);
//
//	    Course updatedTut = new Course("Mech", "40 minutes",startdate, enddate,"700");
//
//	    Course tut = crepo.findById(tut2.getId()).get();
//	    tut.setCoursename(updatedTut.getCoursename());
//	    tut.setDuration(updatedTut.getDuration());
//		  tut.setStartdate(updatedTut.getStartdate());
//		  tut.setEnddate(updatedTut.getEnddate());
//		  tut.setCoursefee(updatedTut.getCoursefee());
//	    
//	    crepo.save(tut);
//
//	    Course checkTut = crepo.findById(tut2.getId()).get();
//	    
//	    assertThat(checkTut.getId()).isEqualTo(tut2.getId());
//	    assertThat(checkTut.getCoursename()).isEqualTo(updatedTut.getCoursename());
//	    assertThat(checkTut.getDuration()).isEqualTo(updatedTut.getDuration());
//	    assertThat(checkTut.getStartdate()).isEqualTo(updatedTut.getStartdate());
//	    assertThat(checkTut.getEnddate()).isEqualTo(updatedTut.getEnddate());
//	    assertThat(checkTut.getCoursefee()).isEqualTo(updatedTut.getCoursefee());
//	 
//	  }
//	 
}
	
	
	

 