package com.igormontezumadev.gestao_vagas.modules.company.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço.")
    private String userName;
    @Email(message = "O campo [email] deve conter um email válido.")
    private String email;
    @Length(min = 6, max = 20)
    private String password;
    private String webSite;
    private String description;
    private String name;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
