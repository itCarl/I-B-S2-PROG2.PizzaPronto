

public abstract class EmployeeVO extends PersonVO {
	
	protected String personnelNo;
	protected float salary;
	protected int vacationDays;
	
	
	/*
	 * Constructors
	 */
	public EmployeeVO() {
		
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
		return super.toString() + " -> Employee [personnelNo=" + personnelNo + ", salary=" + salary + ", vacationDays=" + vacationDays + "]";
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
		this.salary = salary;
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
		this.vacationDays = vacationDays;
	}

}
