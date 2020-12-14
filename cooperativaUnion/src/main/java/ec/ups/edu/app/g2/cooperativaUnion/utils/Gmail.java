package ec.ups.edu.app.g2.cooperativaUnion.utils;

import java.awt.Panel;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.SessionBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Gmail {
	
	public void enviarCorreo(){
		Properties propiedad = new Properties();
		   propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
	        propiedad.setProperty("mail.smtp.starttls.enable", "true");
	        propiedad.setProperty("mail.smtp.port", "587");
	        propiedad.setProperty("mail smtp auth", "true");
	        
	        Session sesion = Session.getDefaultInstance(propiedad);
	        String correoEnvia = "nacipucha.angel1993@gmail.com";
	        String contrasena = "";
	        String receptor = "";
	        String asunto = "";
	        String mensaje="";
	        
	        MimeMessage mail = new MimeMessage(sesion);
	        try {
	            mail.setFrom(new InternetAddress (correoEnvia));
	            mail.addRecipient(Message.RecipientType.TO, new InternetAddress (receptor));
	            mail.setSubject(asunto);
	            mail.setText(mensaje);
	            
	            Transport transportar = sesion.getTransport("smtp");
	            transportar.connect(correoEnvia,contrasena);
	            transportar.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));          
	            transportar.close();
	            
	            JOptionPane.showMessageDialog(null, "Listo, revise su correo");
	            
	            
	        } catch (AddressException ex) {
	            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (MessagingException ex) {
	            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
	        }
	        
	}

}
