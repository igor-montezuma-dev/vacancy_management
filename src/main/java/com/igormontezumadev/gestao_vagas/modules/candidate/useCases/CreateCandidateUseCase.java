package com.igormontezumadev.gestao_vagas.modules.candidate.useCases;

import com.igormontezumadev.gestao_vagas.exceptions.UserFoundException;
import com.igormontezumadev.gestao_vagas.modules.candidate.entities.CandidateEntity;
import com.igormontezumadev.gestao_vagas.modules.candidate.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException("Usuário já cadastrado.");
                });

        var password = this.passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);
        return this.candidateRepository.save(candidateEntity);

    }
}
