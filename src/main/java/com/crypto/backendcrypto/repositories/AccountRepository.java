package com.crypto.backendcrypto.repositories;

import com.crypto.backendcrypto.entitys.Account;
import com.crypto.backendcrypto.entitys.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Query("update Account a set a.email = :email, a.motDePasse=:motDePasse, a.nom=:nom, a.prenom=:prenom, a.telephone=:telephone  where a.id = :id")
    void update(@Param("id")Long id,@Param("nom")String nom ,
                     @Param("prenom")String prenom, @Param("email")String email,
                     @Param("telephone")String telephone,@Param("motDePasse")String motDePasse);
    public Optional<Account> findAccountByEmail (String email);
}
