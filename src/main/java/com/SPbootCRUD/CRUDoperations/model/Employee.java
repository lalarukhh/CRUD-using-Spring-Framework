package com.SPbootCRUD.CRUDoperations.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity    //Entity annotation to make our class as JPA Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "empname")
    private String name;
    @Column(name = "email" )   // this can also work  @Column(name = "email",unique = true)
    private String email = "N/A";
    public String getEmail() {
        return email != null ? email : "";
    }
}
