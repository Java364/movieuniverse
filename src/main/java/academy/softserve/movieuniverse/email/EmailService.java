package academy.softserve.movieuniverse.email;

import academy.softserve.movieuniverse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmailService {

    @Value("${spring.mail.username}")
    private String senderEmail;
    @Value("${subject.welcome.email}")
    private String subject;

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private EmailBuilder emailBuilder;

    public void welcomeEmail(String email, String firstName) throws MailException {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(senderEmail);
            messageHelper.setTo(email);
            messageHelper.setSubject(subject);
            String content = emailBuilder.buildWelcomePage(firstName);
            messageHelper.setText(content, true);
        };
        javaMailSender.send(messagePreparator);
    }

    public void messageSender(User user, String subject, String text) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(user.getEmail());
        mailMessage.setFrom(senderEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(text);
        javaMailSender.send(mailMessage);
    }
}
