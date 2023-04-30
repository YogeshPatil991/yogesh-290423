package com.avisys.cim.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.avisys.cim.pojo.MobileNumber;

@Repository
public interface MobileNumberDao extends JpaRepository<MobileNumber, Long> {

	
	@Query(value = "SELECT m.id, m.number FROM Customers c JOIN mobile_Numbers m WHERE c.id =:customer_id", nativeQuery = true)
	List<MobileNumber> findByMobileNumber(@Param("customer_id") Long customer);

}
