package com.cases.mysqls.service;

import com.cases.mysqls.bean.EmailContactInfo;
import com.cases.mysqls.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    EmailRepository emailRepository;
    @Override
    public EmailContactInfo save(EmailContactInfo emailContactInfo) {
        emailRepository.save(emailContactInfo);
        return emailContactInfo;
    }
}
