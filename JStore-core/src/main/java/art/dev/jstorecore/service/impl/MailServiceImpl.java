package art.dev.jstorecore.service.impl;

import art.dev.jstorecommon.util.log.AutowiredLogger;
import art.dev.jstorecore.service.IMailService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements IMailService {

  private final static String from = "noreply.emailsenderJ@gmail.com";

  @AutowiredLogger Logger logger;
  @Autowired JavaMailSenderImpl mailSender;

  @Async
  @Override public void sendEmail(String subject, String text, String to) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setFrom(from);
    mailMessage.setSubject(subject);
    mailMessage.setText(text);
    mailMessage.setTo(to);

    try {
      mailSender.send(mailMessage);
      logger.debug("Mail send");
    } catch (MailException e) {
      logger.error("Mail send error", e);
    }

  }
}
