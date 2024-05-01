package com.igormontezumadev.gestao_vagas.modules.company.useCases;

import com.igormontezumadev.gestao_vagas.exceptions.UserFoundException;
import com.igormontezumadev.gestao_vagas.modules.company.Dto.AuthCompanyDTO;
import com.igormontezumadev.gestao_vagas.modules.company.repositories.CompanyRepository;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {

        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername())
                .orElseThrow(() ->{
                    throw new UsernameNotFoundException("Empresa não encontrada");
                });
       var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

         if(!passwordMatches){
              throw new AuthenticationException("Senha inválida");
         }
    }
}
