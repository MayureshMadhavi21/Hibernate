//package com.mapping;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class Company {
//    
//	@Id
////	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="Company_Id")
//    private int companyId;
//	
//    private String companyName;
//    
//    //one company has many employees
//    @OneToMany(mappedBy="company")
//    private List<Employee> employees;
//
//	public List<Employee> getEmployees() {
//		return employees;
//	}
//
//	public void setEmployees(List<Employee> employees) {
//		this.employees = employees;
//	}
//
//	public int getCompanyId() {
//		return companyId;
//	}
//
//	public void setCompanyId(int companyId) {
//		this.companyId = companyId;
//	}
//
//	public String getCompanyName() {
//		return companyName;
//	}
//
//	public void setCompanyName(String companyName) {
//		this.companyName = companyName;
//	}
//
//}
