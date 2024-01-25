package first.project.Employee.controller;
import first.project.Employee.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import first.project.Employee.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
// @RestController specifies that this class is a controller for RESFull API requests.
@RequestMapping("/employees/")
// @RequestMapping specifies the base URL for all requests handled by this controller.
@Validated
public class EmployeeController {

    @Autowired
    // @Autowired annotation is used for automatic dependency injection.
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@Valid @RequestBody EmployeeEntity employee) {
    // @RequestBody used to bind the HTTP request body to a parameter in a controller method.
        try {
            employeeService.saveEmployee(employee);
            return ResponseEntity.ok("Employee saved successfully");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            // e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to save employee");
        }
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer employeeId) {
        // @PathVariable annotation is used to extract data from the URL path of an HTTP request.
        if (employeeId != null) {
            employeeService.deleteEmployee(employeeId);
            return ResponseEntity.ok("Employee deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Employee with"+ employeeId +"Not Exists.");
        }
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer employeeId, @Valid @RequestBody EmployeeEntity updatedEmployee) {
        try {
            employeeService.updateEmployee(employeeId, updatedEmployee);
            return ResponseEntity.ok("Employee updated successfully");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update employee");
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(){
        List<EmployeeEntity> employee = employeeService.getAllEmployees();

        return ResponseEntity.ok(employee);
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Integer employeeId) {
        // @PathVariable annotation is used to extract data from the URL path of an HTTP request.
        EmployeeEntity employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Employee not found");
        }
    }

}
