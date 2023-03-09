package com.plateformeweb.orientation.etudiant.ml.Repository;

import com.plateformeweb.orientation.etudiant.ml.Entity.EmailDetails;

public interface EmailService {
		// Method
		// To send a simple email
		String sendSimpleMail(EmailDetails details);
		// Method
				// To send a simple email
		String sendSimpleMails(EmailDetails details);
		// Method
		// To send an email with attachment
		String sendMailWithAttachment(EmailDetails details);
}
