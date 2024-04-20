package com.restv2.rest_v2.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;

@JsonIgnoreProperties(value = {"pass"})
@Schema(description = "Display details about Customer" )
public class Customer {
    private Integer id;
    @Size(min = 2, message = "Name should be more than 2 characters")
    @Schema(description = "Name should be more than 2 characters")
    private String name;
    @Past
    @Schema(description = "Birth date should be past")
    private Date birthDate;

    private String pass;

    protected Customer() {
    }

    public Customer(Integer id, String name, Date birthDate, String password) {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.pass = password;

    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", password=" + pass +
                '}';
    }
}
