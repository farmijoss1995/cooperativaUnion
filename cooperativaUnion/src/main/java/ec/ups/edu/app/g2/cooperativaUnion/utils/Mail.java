package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail implements Serializable {
	
	
	
	public void enviarMail(String destinatario,String asunto, String cuerpo) throws AddressException, MessagingException{
		
		String remitente="bancavirtual2020@gmail.com";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.fallback", "false");
		
		Session mailSesion = Session.getDefaultInstance(props,null);
		mailSesion.getDebug();
		
		Message mailMessaje = new MimeMessage(mailSesion );
		mailMessaje.setFrom(new InternetAddress(remitente));
		mailMessaje.setRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
		//mailMessaje.setContent(cuerpo,"text/xhtml");
		
		mailMessaje.setSubject(asunto);
		mailMessaje.setText(cuerpo);
		
		
		 Transport transportar = mailSesion.getTransport("smtp");
		 transportar.connect("smtp.gmail.com",remitente,"admin_cuenca");
		 transportar.sendMessage(mailMessaje, mailMessaje.getAllRecipients());
		
	}
	

}
