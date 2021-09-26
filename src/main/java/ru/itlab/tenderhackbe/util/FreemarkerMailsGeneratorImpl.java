package ru.itlab.tenderhackbe.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itlab.tenderhackbe.models.SellerNotificationDTO;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
public class FreemarkerMailsGeneratorImpl implements MailsGenerator {
  @Autowired private Configuration configuration;

  @Override
  public String getEmailforConfirm(SellerNotificationDTO sellerNotificationDTO) {
    Template confirmMailTemplate;
    try {
      confirmMailTemplate = configuration.getTemplate("mail/ConfirmMail.ftlh");
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
    // подготовили данные для шаблона

    Map<String, String> attributes = new HashMap<>();
    attributes.put("sellerInn", sellerNotificationDTO.getSellerInn());
    attributes.put("cteName", sellerNotificationDTO.getCteName());
    attributes.put("cteId",sellerNotificationDTO.getCteId());
    attributes.put("sellerName",sellerNotificationDTO.getSellerName());

    StringWriter writer = new StringWriter();
    try {
      // записали в StringWriter текст сообщения
      confirmMailTemplate.process(attributes, writer);
    } catch (IOException | TemplateException e) {
      throw new IllegalStateException(e);
    }
    // получили текст сообщения из шаблона
    return writer.toString();
  }
}
