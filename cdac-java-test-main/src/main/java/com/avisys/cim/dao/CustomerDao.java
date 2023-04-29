package com.avisys.cim.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avisys.cim.pojo.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.firstName = :firstName")
	List<Customer> findByFirstName(@Param("firstName") String firstName);
	
	@Query("SELECT c FROM Customer c WHERE c.lastName = :lastName")
	List<Customer> findByLastName(@Param("lastName") String lastName);
	
	@Query("SELECT c FROM Customer c WHERE c.mobileNumber = :mobileNumber")
    Customer findByMobileNumber(@Param("mobileNumber") String mobileNumber);
	
	@Query("SELECT c FROM Customer c WHERE " +
            "LOWER(c.firstName) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(c.lastName) LIKE LOWER(CONCAT('%',:searchTerm, '%'))")
    List<Customer> findByRandomSearchTerm(@Param("searchTerm") String firstAndLastName);
}
