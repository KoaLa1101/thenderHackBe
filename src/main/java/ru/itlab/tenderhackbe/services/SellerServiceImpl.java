package ru.itlab.tenderhackbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itlab.tenderhackbe.models.CTETableDTO;
import ru.itlab.tenderhackbe.models.SellerInfo;
import ru.itlab.tenderhackbe.models.SellerNotificationDTO;
import ru.itlab.tenderhackbe.repositories.ContractsRepository;
import ru.itlab.tenderhackbe.repositories.CteRepository;
import ru.itlab.tenderhackbe.repositories.SellerInfoRepository;
import ru.itlab.tenderhackbe.util.EmailUtilImpl;
import ru.itlab.tenderhackbe.util.MailsGenerator;

import java.util.List;

@Service
public class SellerServiceImpl {
    @Autowired
    CteRepository cteRepository;

    @Autowired
    ContractsRepository contractsRepository;

    @Autowired
    SellerInfoRepository sellerInfoRepository;

    @Autowired
    EmailUtilImpl emailUtil;

    @Autowired
    MailsGenerator mailsGenerator;

    @Value("${spring.mail.username}")
    private String EMAIL_USERNAME;

    public void sendNotification(List<CTETableDTO> list){
        for (CTETableDTO i:list){
            SellerInfo sellerInfo = sellerInfoRepository.getById(i.getCte_id());
            SellerNotificationDTO mm = SellerNotificationDTO.builder().cteId(i.getCte_id()).cteName(i.getCte_name()).sellerInn(sellerInfo.getSellerInn()).sellerKpp(sellerInfo.getSellerKpp()).sellerName(sellerInfo.getSellerName()).build();
            String msgToSend = mailsGenerator.getEmailforConfirm(mm);
            emailUtil.sendEmail("koala9215@gmail.com", "Main Theme", EMAIL_USERNAME, msgToSend);
        }
    }
}
