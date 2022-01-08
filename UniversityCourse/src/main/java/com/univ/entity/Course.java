package com.univ.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
@Entity
@Table(name="course")
public class Course {
	@Id
	@Column(name="course_id")
    private Long id;
	@Column(name="course_name")
    private String coursename;
	@Column(name="duration")
	private String duration;

    @Column(name="start_date",nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date startdate;

    @Column(name="end_date",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date enddate;
    @Column(name="course_fee")
    private String coursefee;
	public Course() {
		}
	
	public Course(String coursename, String duration, Date startdate, Date enddate, String coursefee) {
		
		this.coursename = coursename;
		this.duration = duration;
		this.startdate = startdate;
		this.enddate = enddate;
		this.coursefee = coursefee;
	}

	public Course(Long id, String coursename, String duration, Date startdate, Date enddate, String coursefee) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.duration = duration;
		this.startdate = startdate;
		this.enddate = enddate;
		this.coursefee = coursefee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public String getCoursefee() {
		return coursefee;
	}

	public void setCoursefee(String coursefee) {
		this.coursefee = coursefee;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", coursename=" + coursename + ", duration=" + duration + ", startdate=" + startdate
				+ ", enddate=" + enddate + ", coursefee=" + coursefee + "]";
	}
	
    

}
