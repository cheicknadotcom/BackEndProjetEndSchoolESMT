package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonFormat;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TableNotification",uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
@Data @AllArgsConstructor @NoArgsConstructor @ToString   
public class NotificationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Intitule")
	private String intitule;
	@Column(name = "Description")
	private String description;
	@Column(name = "Status")
	private String status;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "GMT")
	private Date dateNotification;
}
