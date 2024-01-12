package com.emreilgar.repository;
import com.emreilgar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findOptionalById(Long userid);

    Optional<User> findByEmail(String email);
}
