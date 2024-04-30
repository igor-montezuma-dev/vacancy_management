package com.igormontezumadev.gestao_vagas.modules.company.useCases;

import com.igormontezumadev.gestao_vagas.exceptions.UserFoundException;
import com.igormontezumadev.gestao_vagas.modules.company.entities.CompanyEntity;
import com.igormontezumadev.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent((company) -> {
                    throw new UserFoundException("Usuário já cadastrado!");
                });
        return this.companyRepository.save(companyEntity);
    }
}
