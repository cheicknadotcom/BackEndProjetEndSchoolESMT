package com.plateformeweb.orientation.etudiant.ml.Entity;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UsersComplet{
	private Long id;
	private String nameUsers;
	private String typeUsers;
	private String adresseUsers;
	private String telUsers;
	private String adresseEmailUser;
	private String passwordUser;
	private MultipartFile imageUser;
	public UsersComplet(String adresseEmailUser, String passwordUser) {
		super();
		this.adresseEmailUser = adresseEmailUser;
		this.passwordUser = passwordUser;
	}
	
}
