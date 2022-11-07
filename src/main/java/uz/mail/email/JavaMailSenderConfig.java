package uz.mail.email;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
@RequiredArgsConstructor
public class JavaMailSenderConfig {

    private final EmailProperty property;

    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(property.getHost());
        mailSender.setPort(property.getPort());
        mailSender.setUsername(property.getUsername());
        mailSender.setPassword(property.getPassword());

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", property.getProtocol());
        properties.put("mail.smtp.auth", property.isSmtpAuthEnable());
        properties.put("mail.smtp.starttls.enable", property.isStarttlsEnable());
        properties.put("mail.debug", property.isDebugEnable());

        return mailSender;
    }

}
