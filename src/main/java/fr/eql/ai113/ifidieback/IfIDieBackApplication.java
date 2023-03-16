package fr.eql.ai113.ifidieback;

import fr.eql.ai113.ifidieback.service.CommunicationService;
import fr.eql.ai113.ifidieback.service.impl.CommunicationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class IfIDieBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(IfIDieBackApplication.class, args);
        CommunicationService communicationService = null;
        LocalDate youyou = communicationService.sendMail("ntramier1@gmail.com");
        System.out.println(youyou);
    }

}
