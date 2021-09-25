package ru.itlab.tenderhackbe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultDTO {
    private Long summ;
    private Long id;
    private String CTEName;
}
