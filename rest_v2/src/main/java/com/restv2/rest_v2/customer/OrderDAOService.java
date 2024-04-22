package com.restv2.rest_v2.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Similar to Repository
@Repository
public interface OrderDAOService extends JpaRepository<CustomerOrder, Integer > {
}
