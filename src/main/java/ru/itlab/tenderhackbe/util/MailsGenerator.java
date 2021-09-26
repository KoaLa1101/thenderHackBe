package ru.itlab.tenderhackbe.util;

import ru.itlab.tenderhackbe.models.SellerNotificationDTO;

import java.util.UUID;

public interface MailsGenerator {
  String getEmailforConfirm(SellerNotificationDTO sellerNotificationDTO);
}
