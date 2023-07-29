package com.SPbootCRUD.CRUDoperations.repository;

import com.SPbootCRUD.CRUDoperations.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee,Long> {
// this will contains all CRUD database methods
}
