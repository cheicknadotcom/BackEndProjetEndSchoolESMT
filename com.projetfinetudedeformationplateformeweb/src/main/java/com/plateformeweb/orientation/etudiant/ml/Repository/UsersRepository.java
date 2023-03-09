package com.plateformeweb.orientation.etudiant.ml.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.plateformeweb.orientation.etudiant.ml.Entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	Optional<Users> findUsersByAdresseEmailUserAndPasswordUser(String email, String password);

	Optional<Users> findUsersById(Long id);

	Optional<Users> findUsersByAdresseEmailUser(String email);

	Optional<Users> findUsersByPasswordUser(String crypt);

	//void deleteUsersById(Long id);

	//void deleteUsersByAdresseEmail(String email);

}
