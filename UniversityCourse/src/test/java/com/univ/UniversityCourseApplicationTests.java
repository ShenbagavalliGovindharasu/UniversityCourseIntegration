package com.univ;

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
	
	@MockBean
	StaffRepository srepo;
	
	 
  	@MockBean
    	ApplicantDAO srepo;
    
	
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

	
	//adding staff details test
	@Test
	public void testinsertStaff() {
		Staff s=new Staff();
		
		s.setId(155L);
		s.setStaffname("Ram");
		s.setCourse("CIVIL");
		
		when(srepo.save(s)).thenReturn(s);
		assertThat(srepo.save(s)).isEqualTo(s);
		
		
	}
	
	
	
	//view all staff
	@Test
	public void getAllStaff() {
		List<Staff> staff=new ArrayList();
		staff.add(new Staff());
		given(srepo.findAll()).willReturn(staff);
		List<Staff> expected = srepo.findAll();
		assertEquals(expected, staff);
		verify(srepo).findAll();
		
	}
	

	
	//delete staff using id
	@Test
	public void deleteStaffbyId() {
		Staff staff= new Staff();
		staff.setId(114L);
		staff.setStaffname("Sammu");
		staff.setCourse("commerce");
		when(srepo.findById(staff.getId())).thenReturn(Optional.of(staff));
		srepo.deleteById(staff.getId());
		verify(srepo).deleteById(staff.getId());
	}
	
	//check if repo is empty
	@Test
	public void find_no_staff_if_repo_is_empty() {
		Iterable<Staff> staff = srepo.findAll();

		assertThat(staff).isEmpty();
	}
	
	@Test
      public void testDeleteStaff() {
        Staff staff = new Staff(303L, "aishu", "MECH");
        srepo.save(staff);
        srepo.delete(staff);
    }
	

	  

	  @Test
	    public void testDeleteCourse() throws Exception {
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dateInString1 = "2022-01-05 00:12:00";
			String dateInString2 = "2022-01-15 00:12:00";
			Date startdate = sdf.parse(dateInString2);
			Date enddate = sdf.parse(dateInString1);
	        Course course = new Course(21L, "chemical", "30 minutes", startdate, enddate, "800");
	        crepo.save(course);
	        crepo.delete(course);
	    }
	
	//view all applicant
    @Test
    public void getAllApplicant() {
        List<Applicant> app=new ArrayList();
        app.add(new Applicant());
        given(srepo.findAll()).willReturn(app);
        List<Applicant> expected = (List<Applicant>) srepo.findAll();
        assertEquals(expected, app);
        verify(srepo).findAll();
        
    }
    
    @Test
    public void getAllApplicantById() {
        List<Applicant> app=new ArrayList();
        app.add(new Applicant());
        given(srepo.findAll()).willReturn(app);
        List<Applicant> expected = (List<Applicant>) srepo.findAll();
        assertEquals(expected, app);
        verify(srepo).findAll();
        
        
    }
	
	

}
	
	
	

 
