package com.plateformeweb.orientation.etudiant.ml.Entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@SuppressWarnings("serial")
@Entity
@Table(name= "UsersRoles")
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class RolesUsers implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Labelle_Roles")
	private String labelleRoles;
	@ManyToMany
	@JoinTable(name = "users_and_roles",joinColumns = @JoinColumn(name="users_roles_id"),inverseJoinColumns = @JoinColumn(name="t_utilisateurs_id"))
	private Set<Users> rolesUsers = new HashSet<>();
}
