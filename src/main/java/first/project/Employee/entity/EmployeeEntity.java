package first.project.Employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Employee")
@SequenceGenerator(name = "employee_sequence", sequenceName = "EMPLOYEE_SEQUENCE", allocationSize = 1)
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @Column(name = "EmployeeId")
    private Integer employeeId;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("city")
    private String city;
}
