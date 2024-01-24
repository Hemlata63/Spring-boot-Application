package first.project.Employee.service;

import first.project.Employee.entity.EmployeeEntity;

public interface EmployeeService {
    void saveEmployee(EmployeeEntity employee);

    void updateEmployee(Integer employeeId, EmployeeEntity updatedEmployee);
}

