package fr.eql.ai113.ifidieback;

import fr.eql.ai113.ifidieback.entity.User;
import fr.eql.ai113.ifidieback.repository.CitiesDao;
import fr.eql.ai113.ifidieback.repository.UserDao;
import fr.eql.ai113.ifidieback.service.CommunicationService;
import fr.eql.ai113.ifidieback.service.LoginService;
import fr.eql.ai113.ifidieback.service.impl.CommunicationServiceImpl;
import fr.eql.ai113.ifidieback.service.impl.LoginServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class IfIDieBackApplication {

    Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        SpringApplication.run(IfIDieBackApplication.class, args);

//        //Test sendMail
//        CommunicationServiceImpl com = new CommunicationServiceImpl();
//        LocalDate youyou = com.sendMail("ntramier@gmail.com");
//        System.out.println(youyou);

        //Test Register
//        User register(String lastname, String surname, String password, int addressNb, String addressStreetName,
//                String country, String city, String phoneNumber, String email, LocalDate birthDate)




//    }
//    @Override
//    public void run(String... args) throws Exception {
////
//        try{
//            User user = log.register("Tramier", "Nathalie", "youyou", 11,
//                    "rue du Général Leclerc", "France", "Chevilly-Larue", "0617577460",
//                    "ntramier@gmail.com", LocalDate.of(1979,10,05));
//
//        }catch (NullPointerException e){
//            logger.info("ENCORE UN NULLL", e);
//
//        }


    }
}
