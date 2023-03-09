package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.plateformeweb.orientation.etudiant.ml.Security.SecurityConfig;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
//@Document
@Table(name = "T_utilisateurs",uniqueConstraints = {@UniqueConstraint(columnNames = "AdresseEmail")})
 @AllArgsConstructor @NoArgsConstructor @ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "NameUsers")
	private String nameUsers;
	@Column(name = "Type")
	private String typeUsers;
	@Column(name = "Adresse")
	
	private String adresseUsers;
	@Column(name = "Telephone")

	private String telUsers;
	@Column(name = "AdresseEmail")
	private String adresseEmailUser;
	@Column(name = "Password")
	private String passwordUser;
//	@Column(name = "ImageUsers", length = 1000)
//	private byte[] imageUser;
	@Column(name = "ImageUsers")
	private String imageUser;
	@JsonIgnore
	@ManyToMany(mappedBy = "rolesUsers")
	private Set<RolesUsers> roles = new HashSet<>();

	public Users(String adresseEmailUser, String passwordUser) {
		this.adresseEmailUser = adresseEmailUser;
		setPasswordUser(passwordUser);
	}
	public Users(Long id, String adresseEmailUser, String passwordUser) {
		this(adresseEmailUser,passwordUser);
		this.id = id;
		
	}
	public Users(Long id,String adresseEmailUser,String passwordUser,String tel) {
		this(id,adresseEmailUser,passwordUser);
		this.telUsers = tel;
	}
	public Users(Long id, String nameUsers, String adresseUsers, String telUsers, String adresseEmailUser,
			String passwordUser) {
		this(id,adresseEmailUser,passwordUser);
		this.nameUsers = nameUsers;
		this.adresseUsers = adresseUsers;
		this.telUsers = telUsers;
	}
	
	public Users(Long id2, String name, String type, String addresse, String tel, String email, String password) {
		this(id2,name,addresse,tel,email,password);
		this.typeUsers= type;
	}
	public Users(String nameUsers, String typeUsers, String adresseUsers, String telUsers, String adresseEmailUser,
			String passwordUser) {
		this(adresseEmailUser,passwordUser,telUsers);
		this.nameUsers = nameUsers;
		this.typeUsers = typeUsers;
		this.adresseUsers = adresseUsers;
	}
	public Users(String nom, String type, String addresse, String tel, String adresseEmailUser2, String passwordUser2,
			String  imageUser2) {
		this(nom,type,addresse,tel,adresseEmailUser2,passwordUser2);
		this.imageUser = imageUser2;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNameUsers() {
		return nameUsers;
	}
	public void setNameUsers(String nameUsers) {
		this.nameUsers = nameUsers;
	}
	public String getTypeUsers() {
		return typeUsers;
	}
	public void setTypeUsers(String typeUsers) {
		this.typeUsers = typeUsers;
	}
	public String getAdresseUsers() {
		return adresseUsers;
	}
	public void setAdresseUsers(String adresseUsers) {
		this.adresseUsers = adresseUsers;
	}
	public String getTelUsers() {
		return telUsers;
	}
	public void setTelUsers(String telUsers) {
		this.telUsers = telUsers;
	}
	public String getAdresseEmailUser() {
		return adresseEmailUser;
	}
	public void setAdresseEmailUser(String adresseEmailUser) {
		this.adresseEmailUser = adresseEmailUser;
	}
	public String getPasswordUser() {
		return passwordUser;
	}
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = SecurityConfig.crypt(passwordUser);
	}
	public String  getImageUser() {
		return imageUser;
	}
	public void setImageUser(String  imageUser) {
		this.imageUser = imageUser;
	}
	public Set<RolesUsers> getRoles() {
		return roles;
	}
	public void setRoles(Set<RolesUsers> roles) {
		this.roles = roles;
	}
	public Users(String nameUsers, String adresseEmailUser, String passwordUser) {
		super();
		this.nameUsers = nameUsers;
		this.adresseEmailUser = adresseEmailUser;
		this.passwordUser = passwordUser;
	}
	public Users(String nameUsers, String typeUsers, String adresseUsers, String telUsers) {
		super();
		this.nameUsers = nameUsers;
		this.typeUsers = typeUsers;
		this.adresseUsers = adresseUsers;
		this.telUsers = telUsers;
	}
}
