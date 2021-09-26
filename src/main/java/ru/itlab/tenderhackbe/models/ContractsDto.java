package ru.itlab.tenderhackbe.models;

import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractsDto {

    private String id;
    private Long Quantity;

    public static ContractsDto from(Contracts contracts) {
        if(contracts==null){
            return null;
        }
        return ContractsDto.builder()
                .id(contracts.getCte().getId().toString()).Quantity(Math.round(contracts.getCte().getQuantity())).build();
    }


}
