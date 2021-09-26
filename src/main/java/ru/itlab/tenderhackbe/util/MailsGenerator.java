package ru.itlab.tenderhackbe.util;

import java.util.UUID;

public interface MailsGenerator {
  String getEmailforConfirm(String serverUrl, UUID userId);
}
