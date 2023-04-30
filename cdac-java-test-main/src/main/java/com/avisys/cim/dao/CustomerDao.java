package com.avisys.cim.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.avisys.cim.pojo.Customer;

@Repository
@Transactional
public interface CustomerDao extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT c.id, c.first_name, c.last_name, m.number FROM Customers c JOIN Mobile_Numbers m ON c.id = m.customer_id  WHERE c.first_name = :firstName", nativeQuery = true)
	List<Customer> findByFirstName(@Param("firstName") String firstName);

	@Query(value = "SELECT c.id, c.first_name, c.last_name, m.number FROM Customers c JOIN Mobile_Numbers m ON c.id = m.customer_id  WHERE c.last_name = :lastName", nativeQuery = true)
	List<Customer> findByLastName(@Param("lastName") String lastName);

	@Query(value = "SELECT c.id, c.first_name, c.last_name, m.number FROM Customers c JOIN Mobile_Numbers m ON c.id = m.customer_id  WHERE m.number = :mobileNumber", nativeQuery = true)
	Customer findByMobileNumber(@Param("mobileNumber") String mobileNumber);

}
