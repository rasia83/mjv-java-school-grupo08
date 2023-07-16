package com.mjvinnovation.school.jobby.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Celular {
    private Long numero;
    private boolean whatsapp;
}
