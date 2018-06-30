package com.cases.mysqls.repository;

import com.cases.mysqls.bean.EmailContactInfo;
import com.cases.mysqls.bean.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailContactInfo,Long> {

}
