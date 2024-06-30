package com.restv2.rest_v2.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

// Also called as Repository
@Repository
public interface CacheCustDAOService extends JpaRepository<Customer, Integer> {


}
