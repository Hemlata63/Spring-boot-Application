package first.project.Employee.repository;

import first.project.Employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    EmployeeEntity getReferenceById(Integer employeeId);
}
