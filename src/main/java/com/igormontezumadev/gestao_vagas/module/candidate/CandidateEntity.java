package com.igormontezumadev.gestao_vagas.module.candidate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço.")
    private String username;
    @Email(message = "O campo [email] deve conter um email válido.")
    private String email;
    @Length(min= 6, max =20)
    private String password;
    private String description;
    private String curriculum;
}
