package com.madushan.app.model;

public class Allocation {

	Integer id;
	Integer empid;
	String ProjectName;
	String StartDate;
	String EndDate;
	Allocation Allocation[];

	public Allocation[] getAllocation() {
		return Allocation;
	}

	public void setAllocation(Allocation[] allocation) {
		Allocation = allocation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		this.ProjectName = projectName;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		this.StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		this.EndDate = endDate;
	}
}
