package com.restv2.rest_v2.customer;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"pass"})
@Schema(description = "Display details about Customer" )
@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min = 2, message = "Name should be more than 2 characters")
    @Schema(description = "Name should be more than 2 characters")
    private String name;
    @Past
    @Schema(description = "Birth date should be past")
    private Date birthDate;

    private String pass;

    // create this field in Order
    @OneToMany(mappedBy = "customer" )
    private List<CustomerOrder> posts;

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

    public List<CustomerOrder> getPosts() {
        return posts;
    }

    public void setPosts(List<CustomerOrder> posts) {
        this.posts = posts;
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
