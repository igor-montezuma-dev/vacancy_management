package com.igormontezumadev.gestao_vagas.modules.company.useCases;

import com.igormontezumadev.gestao_vagas.modules.company.entities.JobEntity;
import com.igormontezumadev.gestao_vagas.modules.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CreateJobUseCase {
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(@RequestBody JobEntity jobEntity) {

        return this.jobRepository.save(jobEntity);
    }
}
