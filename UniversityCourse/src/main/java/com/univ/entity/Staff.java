package com.univ.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="staff")
public class Staff {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Staff_Id")
	private Long id;
	
	@Column(name="Staff_Name")
	private String staffname;
	
	@Column(name="Course")
	private String course;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(Long id, String staffname, String course) {
		super();
		this.id = id;
		this.staffname = staffname;
		this.course = course;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getCourse() {
		return course;
	}

	@Override
	public String toString() {
		return "Staff [id=" + id + ", staffname=" + staffname + ", course=" + course + "]";
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
