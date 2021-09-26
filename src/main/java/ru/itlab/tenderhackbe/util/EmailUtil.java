package ru.itlab.tenderhackbe.util;

public interface EmailUtil {
  void sendEmail(String to, String subject, String from, String text);
}
