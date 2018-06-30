package com.cases.mysqls.service;

import com.cases.mysqls.bean.EmailContactInfo;
import com.cases.mysqls.bean.OrderHeader;

public interface EmailService {
    public EmailContactInfo save(EmailContactInfo emailContactInfo);
}
