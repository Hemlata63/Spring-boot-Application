package first.project.Employee.service;

import first.project.Employee.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeEntity employee);

    void updateEmployee(Integer employeeId, EmployeeEntity updatedEmployee);

    List<EmployeeEntity> getAllEmployees();

    EmployeeEntity getEmployeeById(Integer employeeId);
}

