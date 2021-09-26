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
    private String cte_id;
    private String cte_name;
    public static CTETableDTO from(Cte cte){
        return CTETableDTO.builder().cte_id(cte.getCteId().toString()).cte_name(cte.getCteName()).build();
    }
}
