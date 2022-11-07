package uz.mail.email;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailSender {

    private final JavaMailSender mailSender;

    public void sendEmail(@NotNull SimpleEmail email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email.getReceiver());
        message.setSubject(email.getSubject());
        message.setText(email.getText());
        mailSender.send(message);
    }

    @Bean
    public void send() {
        sendEmail(SimpleEmail.builder()
                .receiver("axmatov0713@gmail.com")
                .subject("Hello ")
                .text("This is a hello from no one")
                .build());
    }

}
