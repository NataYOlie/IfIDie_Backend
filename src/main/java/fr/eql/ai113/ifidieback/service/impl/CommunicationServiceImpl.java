package fr.eql.ai113.ifidieback.service.impl;
import fr.eql.ai113.ifidieback.service.CommunicationService;
import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDate;
import java.util.Properties;

@Service
public class CommunicationServiceImpl implements CommunicationService {

    private static final String FROM = "ntramier@gmail.com";
    private static final String SMTP = "smtp.gmail.com";

    /**
     * This Method send a validation email
     * code from : https://netcorecloud.com/tutorials/send-email-in-java-using-gmail-smtp/
     * @param emailTo must be someone@somemailserver.something
     * @return LocalDate of sent email, if null email was not sent.
     */
    @Override
    public LocalDate sendMail(String emailTo) {
        LocalDate isSent = null;

        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.put("mail.smtp.host", SMTP);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("fromaddress@gmail.com", "*******");
            }
        });
            // Used to debug SMTP issues
        session.setDebug(true);

        try {
                // Create a default MimeMessage object.
                MimeMessage message = new MimeMessage(session);

                // Set From: header field of the header.
                message.setFrom(new InternetAddress(FROM));

                // Set To: header field of the header.
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));

                // Set Subject: header field
                message.setSubject("This is the Subject Line!");

                // Now set the actual message
                message.setText("This is actual message");

                System.out.println("sending...");
                // Send message
                Transport.send(message);
                isSent = LocalDate.now();
                System.out.println("Sent message successfully....");
            } catch (AddressException mex) {
                mex.printStackTrace();
            } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        return isSent;
    }
    @Override
    public LocalDate sendSms(String phoneNumber) {
        return null;
    }
}
