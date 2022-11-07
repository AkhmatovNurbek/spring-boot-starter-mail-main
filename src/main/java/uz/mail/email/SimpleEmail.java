package uz.mail.email;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class SimpleEmail {

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String subject;

    @NotEmpty
    private String text;

    @NotNull
    private String sender;

    @NotNull
    private String receiver;

}
