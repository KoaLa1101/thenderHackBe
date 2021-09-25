package ru.itlab.tenderhackbe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CTETableDTO
{
    private Long cteId;
    private String cteName;
}
