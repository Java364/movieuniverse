package academy.softserve.movieuniverse.email;

import academy.softserve.movieuniverse.entity.User;
import academy.softserve.movieuniverse.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailBuilder {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private TemplateEngine templateEngine;

    public String buildWelcomePage(String firstName) {
        Context context = new Context();
        context.setVariable("firstName", firstName);
        return templateEngine.process("welcome.html", context);
    }

    public void newPassword(String email) {
        User userEmail = userRepository.findByEmail(email);
        String newpassword = RandomStringUtils.randomAlphanumeric(10);
        String encodedPassword = passwordEncoder.encode(newpassword);
        userEmail.setPassword(encodedPassword);
        userEmail = userRepository.saveAndFlush(userEmail);
        emailService.messageSender(userEmail, "New password!", "Your new password is: " + newpassword);
    }
}
