package com.univ.controller;

import java.util.List;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.univ.entity.Staff;

import com.univ.exception.StaffNotFoundException;
import com.univ.repository.StaffRepository;

@RestController
@RequestMapping("/univ")
public class StaffController {
	
	
	@Autowired
	public StaffRepository staffRepository;
	
	@GetMapping(path="/display")
	public String display() {
		return "hello";
	}
	
	//display all staff records
	@GetMapping("/getallstaff")
	public List<Staff> getAllStaff(){
		return staffRepository.findAll();
	}
	
	//save staff record
	@PostMapping(path="/savestaff",consumes="application/json")
    public Staff createStaff(@Valid @RequestBody Staff staff) {
		
        return staffRepository.save(staff);
    }
	
	
	
	//update staff details
	@PutMapping("/updatestaff")
	public Staff update(@RequestBody Staff staff) {
		return staffRepository.save(staff);
	}
	
	//delete staff details using id
	@RequestMapping(value="/deletestaff/{id}",method=RequestMethod.DELETE)
    public void  deleteStaff(@PathVariable("id") long id) {

    staffRepository.deleteById(id);

    }
	
	//update staff details using staff id
	@PutMapping("/updatebyid/{id}")
	public Staff updateNote(@PathVariable(value = "id") Long staffId,
	                                 @Valid @RequestBody Staff staffDetails) throws StaffNotFoundException {

		 Staff staff;
	        if (staffRepository.findById(staffId).isEmpty()) {
	            throw new StaffNotFoundException("No staff exist in id: "+staffId, staffId);
	        } else {
	            staff = staffRepository.findById(staffId).get();
	        }
	        return staff;
		
	    
	}
	
	
	
}
