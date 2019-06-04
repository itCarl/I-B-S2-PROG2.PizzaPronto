package de.thb.dim.pizzaPronto.valueObjects;

/**
 * EmployeeVO - Contains the Value Object of Employees
 * Uebung 5 - 23.05.2019
 * @author Maximilian Mewes
 * @version 1.0
 *
 */
public abstract class EmployeeVO extends PersonVO {
	
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	
	
	/*
	 * Constructors
	 */
	public EmployeeVO() {
		this(null, null, null);
	}
	
	public EmployeeVO(String personnelNo, String lastName, String firstName) {
		super(lastName, firstName);
		this.setPersonnelNo(personnelNo);
	}

	

	/*
	 * Helper / General Methods
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((personnelNo == null) ? 0 : personnelNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (this.getClass() != obj.getClass())
			return false;
		
		EmployeeVO employee = (EmployeeVO) obj;
		if (this.personnelNo == null) {
			if (employee.personnelNo != null)
				return false;
		} else if (!personnelNo.equals(employee.personnelNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + " -> Employee [personnelNo=" + this.personnelNo + ", salary=" + this.salary + ", vacationDays=" + this.vacationDays + "]";
	}

	
	
	/**
	 * @return the personnelNo
	 */
	public String getPersonnelNo() {
		return personnelNo;
	}

	/**
	 * @param personnelNo the personnelNo to set
	 */
	public void setPersonnelNo(String personnelNo) {
		this.personnelNo = personnelNo;
	}

	/**
	 * @return the salary
	 */
	public float getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(float salary) {
		/*if(salary > 0.0f) {
			this.salary = salary;
		} else {
			this.salary = -1;
		}*/
		
		this.salary = (salary > 0.0f) ? salary : -1;
		
	}

	/**
	 * @return the vacationDays
	 */
	public int getVacationDays() {
		return vacationDays;
	}

	/**
	 * @param vacationDays the vacationDays to set
	 */
	public void setVacationDays(int vacationDays) {
		this.vacationDays = (vacationDays >= 0) ? vacationDays : -1;
	}

}
