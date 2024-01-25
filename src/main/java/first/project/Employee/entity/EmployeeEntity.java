package first.project.Employee.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity // @Entity specifies that this class is an entity and should be mapped to a database table.
@Data
@Table(name = "Employee")
// @Table specifies the name of the database table that will store instances of this entity.
@SequenceGenerator(name = "employee_sequence", sequenceName = "EMPLOYEE_SEQUENCE", allocationSize = 1)
public class EmployeeEntity {

    @Id  // @Id specifies the primary key of the entity
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence") // @GeneratedValue specifies that the primary key should be generated automatically.

    @NotBlank(message = "")
    @Column(name = "EmployeeId")
    private Integer employeeId;

    @NotBlank(message = "FirstName can not be blank")
    @JsonProperty("FirstName")
    private String firstName;

    @NotBlank(message = "LastName can not be blank")
    @JsonProperty("LastName")
    private String lastName;

    @NotBlank(message = "Address can not be blank")
    @JsonProperty("Address")
    private String address;

    @NotBlank(message = "City can not be blank")
    @JsonProperty("city")
    private String city;
}
