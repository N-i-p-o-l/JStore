package art.dev.jstorecore.service;

public interface IMailService {

  void sendEmail(String subject, String text, String to);
}
