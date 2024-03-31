package com.api.instrumentosmusicais.repositories;

import com.api.instrumentosmusicais.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByUsernameAndPassword(String username, String password);
}
