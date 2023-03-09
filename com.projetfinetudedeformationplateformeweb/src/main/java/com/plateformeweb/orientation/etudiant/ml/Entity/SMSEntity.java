package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name = "T_sms")
@Data @NoArgsConstructor @ToString
public class SMSEntity implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "To")
	private String to;
	@Column(name = "From")
	private String from;
	@Column(name = "Message")
	private String messages;
}
