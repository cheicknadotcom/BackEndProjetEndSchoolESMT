package com.plateformeweb.orientation.etudiant.ml.Services;
import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.plateformeweb.orientation.etudiant.ml.Entity.EmailDetails;
import com.plateformeweb.orientation.etudiant.ml.Repository.EmailService;



//Annotation
@Service
//Class
//Implementing EmailService interface
public class EmailServiceImpl implements EmailService {

	@Autowired private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") private String sender;
	
	// Method 1
	// To send a simple email
	public String sendSimpleMail(EmailDetails details)
	{

		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage
				= new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());

			// Sending the mail
			javaMailSender.send(mailMessage);
			
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}
	
	// Method 2
	// To send an email with attachment
	public String
	sendMailWithAttachment(EmailDetails details)
	{
		// Creating a mime message
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;

		try {

			// Setting multipart as true for attachments to
			// be send
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(details.getRecipient());
			mimeMessageHelper.setText(details.getMsgBody());
			mimeMessageHelper.setSubject(details.getSubject());

			// Adding the attachment
			FileSystemResource file = new FileSystemResource( new File(details.getAttachment()));

			mimeMessageHelper.addAttachment(file.getFilename(), file);
			// Sending the mail
			javaMailSender.send(mimeMessage);
			return "Mail sent Successfully";
		}

		// Catch block to handle MessagingException
		catch (MessagingException e) {

			// Display message when exception occurred
			return "Error while sending mail!!!";
		}
	}

	public String sendSimpleMails(EmailDetails details) {
		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage = new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(details.getTo());
			mailMessage.setTo(details.getRecipient());
			mailMessage.setText(details.getMsgBody());
			mailMessage.setSubject(details.getSubject());

			// Sending the mail
			javaMailSender.send(mailMessage);
			return "Mail Sent Successfully...";
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return "Error while Sending Mail";
		}
	}
//	@SuppressWarnings("unused")
//	private EmailDetails envoyerEmailEntity(EmailDetails emailDetails) {
//		// Try block to check for exceptions
//				try {
//
//					// Creating a simple mail message
//					SimpleMailMessage mailMessage = new SimpleMailMessage();
//
//					// Setting up necessary details
//					mailMessage.setFrom(emailDetails.getTo());
//					mailMessage.setTo(emailDetails.getRecipient());
//					mailMessage.setText(emailDetails.getMsgBody());
//					mailMessage.setSubject(emailDetails.getSubject());
//
//					// Sending the mail
//					javaMailSender.send(mailMessage);
//					
//					return emailRepository.save(emailDetails);
//				}
//
//				// Catch block to handle the exceptions
//				catch (Exception e) {
//					return null;
//				}
//	}
}
