package fr.eql.ai113.ifidieback.service;

import fr.eql.ai113.ifidieback.entity.User;
import org.hibernate.validator.internal.util.privilegedactions.LoadClass;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public interface CommunicationService {

    LocalDate sendMail(String email);
    LocalDate sendSms (String phoneNumber);
}
