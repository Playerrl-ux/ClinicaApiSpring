package org.example.dto;

import java.util.Date;

public record ConsultaDto(String cliente, String medico, Date date, double valor) {
}
