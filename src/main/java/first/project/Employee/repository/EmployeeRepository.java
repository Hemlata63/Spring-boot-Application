package first.project.Employee.repository;

import first.project.Employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
// @Repository specifies that this interface is a repository, and Spring will create an instance of it automatically.
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {
// The JpaRepository interface provides a set of methods for performing CRUD(Create, Read, Update, Delete) operations on the “Employee” entity.
    EmployeeEntity getReferenceById(Integer employeeId);

    List<EmployeeEntity> findAllByEmployeeId(Integer employeeId);
}
