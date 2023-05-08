package fr.eql.ai113.ifidieback;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class IfIDieBackApplication {

    Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(IfIDieBackApplication.class, args);


    }
}
