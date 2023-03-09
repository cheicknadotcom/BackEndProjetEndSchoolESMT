package com.plateformeweb.orientation.etudiant.ml.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class EmailDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Class data members
	private String to;
	private String recipient;
	private String msgBody;
	private String subject;
	private String attachment;
	public EmailDetails(String recipient, String msgBody, String subject) {
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
		
	}
	public EmailDetails(String to,String recipient, String msgBody, String subject, String attachment) {
		this(to,recipient,msgBody,subject);
		this.attachment = attachment;
	}
	public EmailDetails(String to, String recipient, String msgBody, String subject) {
		this.to = to;
		this.recipient = recipient;
		this.msgBody = msgBody;
		this.subject = subject;
	}

}
