package ru.itlab.tenderhackbe.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerNotificationDTO {

    private String sellerInn;
    private String sellerName;
    private String cteId;
    private String cteName;
}
