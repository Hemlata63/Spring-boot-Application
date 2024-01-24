package first.project.Employee.repository;

import first.project.Employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    EmployeeEntity getReferenceById(Integer employeeId);

    List<EmployeeEntity> findAllByEmployeeId(Integer employeeId);
}
