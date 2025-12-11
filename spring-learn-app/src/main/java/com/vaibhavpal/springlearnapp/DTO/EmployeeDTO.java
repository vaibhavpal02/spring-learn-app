package com.vaibhavpal.springlearnapp.DTO;

import com.vaibhavpal.springlearnapp.annotations.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name not null, as well as not empty.")
    @Size(min = 3, max = 10, message = "No. of character should be in range [3-10]")
    private String name;

    @Email(message = "Enter a valid email.")
    private String email;

    @Min(value = 18, message = "Age cannot be less than 18")
    @Max(value = 80, message = "Age cannot be more than 80.")
    private Integer age;

    private LocalDate doj;

//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role must be ADMIN or USER")
    @EmployeeRoleValidation
    private String role;

    @NotNull
    @Positive(message="Can't be negative")
    private Integer salary;

    private boolean active;

    public EmployeeDTO() {}

    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate doj, String role,Integer salary, boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.doj = doj;
        this.role = role;
        this.salary=salary;
        this.active = active;
    }
}
