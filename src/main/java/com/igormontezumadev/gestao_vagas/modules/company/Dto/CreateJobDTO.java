package com.igormontezumadev.gestao_vagas.modules.company.Dto;

import lombok.Data;

@Data
public class CreateJobDTO {

    private String description;
    private String benefits;
    private String level;
}