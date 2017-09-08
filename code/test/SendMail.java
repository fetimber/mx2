package test;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMail {
	public void send163ByMutil() throws MessagingException {
		JavaMailSenderImpl javaMail = new JavaMailSenderImpl();
		javaMail.setHost("smtp.163.com");
		javaMail.setPassword("md5pa$$w0rd");
		javaMail.setUsername("publiction@163.com");
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.auth", "true");
		javaMail.setJavaMailProperties(prop);
		MimeMessage message = javaMail.createMimeMessage();
		MimeMessageHelper messageHelp = new MimeMessageHelper(message, true, "GBK");
		messageHelp.setFrom("publiction@163.com");
		messageHelp.setTo("huxiaochen@hmeg.net");
		messageHelp.setSubject("邮件测试");
		// messageHelp
		String body = "<html><head><META http-equiv=Content-Type content='text/html; charset=GBK'></HEAD><title>test</title></head><body>dear 小燕子 \n ";
		body += "<red>This is Text!</red> pic <img src='cid:a'></img><br>hello<img src='cid:b'></img></body></html>";
		messageHelp.setText(body, true);
		javaMail.send(message);
	}

	public static void main(String[] args) throws MessagingException {
		SendMail send = new SendMail();
		send.send163ByMutil();

	}
}
