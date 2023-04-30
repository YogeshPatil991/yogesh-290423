package com.avisys.cim.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avisys.cim.pojo.MobileNumber;

@Repository
public interface MobileNumberDao extends JpaRepository<MobileNumber, Long> {


}
