package memberStudy;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

//JavaMail API에서 메일을 전송하는 과정은 3가지로 분류된다.
//1. javax.mail.Session 클래스의 인스턴스를 생성한다.
//2. javax.mail.Message 클래스를 사용하여 전송하고자 하는 메일의 메시지를 작성한다.
//3. javax.mail.Transport 클래스를 사용하여 작성한 메일을 전송한다.

public class EmailConfirm {
	public String connectEmail(String email) {
		String to1 = email;	// 인증을 위해 사용자가 입력하는 이메일 주소
		String host = "smtp.gmail.com";	// smtp 서버
		String subject = "인증번호 전송";	// 보내는 제목 설정
		String fromName = "관리자";	// 보내는 이름 설정
		String from = "develop.leoh7@gmail.com";	// 보내는 사람(구글 계정)
		String pass = "leoh7@icloud.com";
		String authNum = EmailConfirm.authNum();	// 인증번호 난수 생성
		String content = "인증번호 ["+authNum+"]";		// 이메일 내용 설정
		
		
		try {
	// 1. Session 생성
		// SMTP 서버와 관련된 정보를 지정
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");	// gmail 인증용 Secure Socket Layer(SSL) 설정
		props.put("mail.transport.protocol", "smtp");	// 프로토콜 설정
		props.put("mail.smtp.host", host);				// gmail SMTP 서비스 주소(호스트)
		props.setProperty("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port","587");
		props.put("mail.smtp.user",from);
		props.put("mail.smtp.auth","true");				// SMTP 인증을 설정
		
		Session mailSession
			= Session.getInstance(
				props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication
							(from, pass);
				}
			});
		
		Message msg = new MimeMessage(mailSession);
		InternetAddress []address1 = {new InternetAddress(to1)};
		msg.setFrom(new InternetAddress
				(from, MimeUtility.encodeText(fromName, "utf-8", "B")));
		msg.setRecipients(Message.RecipientType.TO, address1);	// 받는사람 설정
		msg.setSubject(subject);	// 제목 설정
		msg.setSentDate(new java.util.Date());	// 보내는 날짜 설정
		msg.setContent(content,"text/html; charset=utf-8");	//내용 설정
		
		Transport.send(msg);	// 메일 보내기
		}catch(MessagingException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return authNum;
	}
	
	public static String authNum() {
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i<5; i++) {
			int num = (int)(Math.random()*9+1);
			buffer.append(num);
		}
		return buffer.toString();
	}
}





