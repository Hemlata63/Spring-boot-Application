package first.project.Employee.service1;

import first.project.Employee.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import first.project.Employee.repository.EmployeeRepository;
import first.project.Employee.service.EmployeeService;

import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Integer employeeId, EmployeeEntity updatedEmployee) {
        Optional<EmployeeEntity> optionalExistingEmployee = employeeRepository.findById(employeeId);

        if (optionalExistingEmployee.isPresent()) {
            EmployeeEntity existingEmployee = optionalExistingEmployee.get();
            BeanUtils.copyProperties(updatedEmployee, existingEmployee, "employeeId");

            employeeRepository.save(existingEmployee);
        }
    }
}



