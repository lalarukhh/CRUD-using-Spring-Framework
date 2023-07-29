package com.SPbootCRUD.CRUDoperations.dto;

import com.SPbootCRUD.CRUDoperations.model.Employee;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDto {
    public Long id;
    public String name;
    public String email;

}
