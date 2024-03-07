package com.mapping;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Employee {
   
	@Id
	@Column(name="Employee_Id")
    private int employeeId;
    private String employeeName;
    
	@ManyToMany
	@JoinTable
	(
			name="employee_projects_list",
			joinColumns = { @JoinColumn(name="Employee_Id")},
			inverseJoinColumns = { @JoinColumn(name="Project_ID")}
	)
    private List<Project> projects;
    
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}	
    
}
